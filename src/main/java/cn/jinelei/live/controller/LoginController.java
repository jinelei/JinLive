package cn.jinelei.live.controller;

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
import org.springframework.http.HttpRequest;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by jinelei on 17-3-26.
 */
@Controller
@PropertySource("classpath:/application.properties")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Value("${tomcat_server_ip}")
    private String tomcat_server_ip;


//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String loginPost(@RequestParam(value = "error", required = false) String error,
//                        @RequestParam(value = "logout", required = false) String logout,
//                        ModelMap model) {
//        logger.debug("login post");
//        if (error != null)
//            model.addAttribute("error", "Invalid username and password!");
//        if (logout != null)
//            model.addAttribute("msg", "You've been logged out successfully.");
//        return "/login";
//    }


}
