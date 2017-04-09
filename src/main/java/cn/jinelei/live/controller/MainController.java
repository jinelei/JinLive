package cn.jinelei.live.controller;

import cn.jinelei.live.model.data.Room;
import cn.jinelei.live.model.data.ViRoomUserCategory;
import cn.jinelei.live.service.RoomService;
import cn.jinelei.live.service.UserService;
import cn.jinelei.live.service.ViRoomUserCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

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
    private Environment environment;
    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private RoomService roomService;
    @Autowired
    private UserService userService;
    @Autowired
    private ViRoomUserCategoryService viRoomUserCategoryService;

    @Value("${tomcat_server_ip}")
    private String tomcat_server_ip;

    @RequestMapping(value = {"/index", "/"})
    public String index(ModelMap model) {
        List<ViRoomUserCategory> viRoomUserCategories = viRoomUserCategoryService.getAllViRoomUserCategory();
        logger.debug("room size: " + viRoomUserCategories.size());
        model.addAttribute("rooms", viRoomUserCategories);
//        userService.getAllUser().forEach(user -> System.out.println(user));
        logger.debug(model.toString());
        return "index";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String test(ModelMap model) {
        return "information";
    }

    @RequestMapping("/test")
    public String test() {
//        template.convertAndSend("/topic/msg","asdasdf");
        Object object = wac.getBean("sqlSessionFactory");
        assert object == null;
        return "fileupload";
    }

    @RequestMapping(value = "/room", method = RequestMethod.POST)
    public String roomPost(ModelMap model, @RequestParam(value = "stream_key") String streamKey) {
        logger.debug("stream_key: " + streamKey);
        String url = environment.getProperty("server_ip");
        model.addAttribute("server_ip", url);
        model.addAttribute("stream_key", streamKey);
        logger.debug(model.toString());
        return "room";
    }

}
