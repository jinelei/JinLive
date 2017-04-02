package cn.jinelei.live.controller;

import cn.jinelei.live.model.Shout;
import cn.jinelei.live.model.nginx.Application;
import cn.jinelei.live.model.nginx.RTMP;
import cn.jinelei.live.model.nginx.live.Live;
import cn.jinelei.live.model.nginx.vod.Vod;
import cn.jinelei.live.utils.handler.EntityHandler;
import cn.jinelei.live.utils.net.HttpTools;
import cn.jinelei.live.utils.rtmp.RTMPCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.messaging.handler.annotation.MessageMapping;
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
public class STOMPController {

    private static final Logger logger = LoggerFactory.getLogger(STOMPController.class);

    @Autowired
    private RTMPCacheManager rtmpCacheManager;
    @Autowired
    private EntityHandler entityHandler;
    @Autowired
    private HttpTools httpTools;
    @Autowired
    private Environment environment;

    @MessageMapping("/msg")
    public void handleMessage(String msg){
        logger.debug(msg);
    }

}
