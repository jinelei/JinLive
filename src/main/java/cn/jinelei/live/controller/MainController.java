package cn.jinelei.live.controller;

import cn.jinelei.live.model.data.ViRoomUserCategory;
import cn.jinelei.live.service.RoomService;
import cn.jinelei.live.service.UserService;
import cn.jinelei.live.service.ViRoomUserCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by jinelei on 17-3-26.
 */
@Controller
@PropertySource("classpath:/application.properties")
@RequestMapping(value = "/")
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired(required = false)
    private SimpMessagingTemplate template;
    @Autowired
    private RoomService roomService;
    @Autowired
    private UserService userService;
    @Autowired
    private ViRoomUserCategoryService viRoomUserCategoryService;

    @RequestMapping(value = {"/index", "/"})
    public ModelAndView index(ModelAndView model) {
        List<ViRoomUserCategory> viRoomUserCategories = viRoomUserCategoryService.getAllViRoomUserCategory();
        logger.debug("room size: " + viRoomUserCategories.size());
        model.setViewName("index");
        model.addObject("rooms", viRoomUserCategories);

        logger.debug(model.toString());
        return model;
    }


    @RequestMapping(value = "/temp", method = RequestMethod.GET)
    public ModelAndView template(ModelAndView model) {
        model.setViewName("template");
        return model;
    }

    @RequestMapping("/test")
    public ModelAndView test(ModelAndView model, HttpServletRequest request) {
//        request.getSession().setAttribute("jin", "asdf");
//        String str = (String) request.getSession().getAttribute("jin");
//        logger.debug(str);
//        template.convertAndSend("/topic/msg","asdasdf");
//        return "fileupload";
        model.setViewName("test");
        return model;
    }


}
