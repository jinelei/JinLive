package cn.jinelei.live.controller;

import cn.jinelei.live.exception.UserException;
import cn.jinelei.live.model.data.User;
import cn.jinelei.live.model.data.ViRoomUserCategory;
import cn.jinelei.live.model.enumstatus.user.UserStatus;
import cn.jinelei.live.service.RoomService;
import cn.jinelei.live.service.UserService;
import cn.jinelei.live.service.ViRoomUserCategoryService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    private SimpMessagingTemplate template;
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private RoomService roomService;
    @Autowired
    private UserService userService;
    @Autowired
    private ViRoomUserCategoryService viRoomUserCategoryService;

    @RequestMapping(value = {"/index", "/"})
    public String index(ModelMap model) {
        List<ViRoomUserCategory> viRoomUserCategories = viRoomUserCategoryService.getAllViRoomUserCategory();
        logger.debug("room size: " + viRoomUserCategories.size());
        model.addAttribute("rooms", viRoomUserCategories);

//        logger.debug(model.toString());
        return "index";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String test(ModelMap model) {
        return "information";
    }

    @RequestMapping("/test")
    public String test(HttpServletRequest request) {
//        request.getSession().setAttribute("jin", "asdf");
//        String str = (String) request.getSession().getAttribute("jin");
//        logger.debug(str);
//        template.convertAndSend("/topic/msg","asdasdf");
        return "fileupload";
    }

    @RequestMapping(value = "/room", method = RequestMethod.POST)
    public String roomPost(ModelMap model, @RequestParam(value = "stream_key") String streamKey) {
        logger.debug("stream_key: " + streamKey);
        model.addAttribute("stream_key", streamKey);
        logger.debug(model.toString());
        return "room";
    }


}
