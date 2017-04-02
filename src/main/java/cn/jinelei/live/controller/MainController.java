package cn.jinelei.live.controller;

import cn.jinelei.live.model.nginx.Application;
import cn.jinelei.live.model.nginx.live.Live;
import cn.jinelei.live.model.nginx.vod.Vod;
import cn.jinelei.live.utils.handler.EntityHandler;
import cn.jinelei.live.model.nginx.RTMP;
import cn.jinelei.live.utils.net.HttpTools;
import cn.jinelei.live.utils.rtmp.RTMPCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Created by jinelei on 17-3-26.
 */
@Controller
@PropertySource("classpath:/application.properties")
@RequestMapping(value = "/")
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private RTMPCacheManager rtmpCacheManager;
    @Autowired
    private EntityHandler entityHandler;
    @Autowired
    private HttpTools httpTools;
    @Autowired
    private Environment environment;
    @Autowired
    private SimpMessagingTemplate template;

    @RequestMapping(value = {"/index", "/"})
    public String index(ModelMap model) {
        logger.debug("Current Method Name: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        RTMP rtmp = rtmpCacheManager.getRTMP();
        List<Application> applicationList = rtmp.getServer().getApplications();
        applicationList.forEach((application -> {
            logger.debug("name: " + application.getName());
            if ("vod".equals(application.getName())) {
                logger.debug("vod -------------------------");
                List<cn.jinelei.live.model.nginx.vod.Stream> vodStreams = ((Vod) application).getStreams();
                model.addAttribute("vodStreams", vodStreams);
            } else if ("live".equals(application.getName())) {
                logger.debug("live -------------------------");
                List<cn.jinelei.live.model.nginx.live.Stream> liveStreams = ((Live) application).getStreams();
                model.addAttribute("liveStreams", liveStreams);
            }
        }));
        logger.debug(rtmp.toString());
        return "index";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String test(ModelMap model) {
        RTMP rtmp = rtmpCacheManager.getRTMP();
        model.addAttribute("rtmp", rtmp);
        return "information";
    }

    @RequestMapping("/test")
    public String test() {
        template.convertAndSend("/topic/msg","asdasdf");
        return "fileupload";
    }

    @RequestMapping(value = "/room", method = RequestMethod.POST)
    public String roomPost(ModelMap model, @RequestParam(value = "stream_id") String streamId) {
        logger.debug("stream_id: " + streamId);
        String url = environment.getProperty("server_ip");
        model.addAttribute("server_ip", url);
        model.addAttribute("stream_id", streamId);
        return "room";
    }

}
