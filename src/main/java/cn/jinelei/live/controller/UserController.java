package cn.jinelei.live.controller;

import cn.jinelei.live.exception.UserException;
import cn.jinelei.live.model.data.User;
import cn.jinelei.live.model.data.ViUserSubscribe;
import cn.jinelei.live.model.enumstatus.user.UserStatus;
import cn.jinelei.live.service.UserService;
import cn.jinelei.live.service.ViUserSubscribeService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by jinelei on 17-3-26.
 */
@Controller
@PropertySource("classpath:/application.properties")
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ViUserSubscribeService viUserSubscribeService;


    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;

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


    @ResponseBody
    @RequestMapping(value = "/loginAjax", method = RequestMethod.GET)
    public String loginAjax(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            HttpServletRequest request) {
        User user = new User();
        Gson gson = new Gson();
        logger.debug(gson.toJson(user));
        return gson.toJson(user);
    }

    @ResponseBody
    @RequestMapping(value = "/loginAjax", method = RequestMethod.POST)
    public String loginAjaxPost(@RequestParam(value = "username", required = false) String username,
                                @RequestParam(value = "password", required = false) String password,
                                HttpServletRequest request) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        Gson gson = new Gson();
        boolean res = userService.verifyUser(username, password);
        JsonObject jsonObject = new JsonObject();
        if (res) {
            try {
                User user = userService.getUserInfo(username);
                if ((user.getUserStatus() & Integer.valueOf(UserStatus.ANCHOR.toString())) != 0) {
                    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ANCHOR"));
                }
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetailsService.loadUserByUsername(user.getUserName()), password, grantedAuthorities);
                authentication.setDetails(new WebAuthenticationDetails(request));

                logger.debug(authentication.toString());

                SecurityContextHolder.getContext().setAuthentication(authentication);
                String userName = SecurityContextHolder.getContext().getAuthentication().getName();
                jsonObject.addProperty("status", "0");
                jsonObject.addProperty("user", userName);
            } catch (UserException e) {
                e.printStackTrace();
            }
        } else {
            jsonObject.addProperty("status", "1");
        }
        logger.debug(jsonObject.toString());
        return jsonObject.toString();
    }


    @RequestMapping(value = "info", method = RequestMethod.GET)
    public ModelAndView info(ModelAndView model, HttpServletRequest request) {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addObject("user", object);
        model.setViewName("user-info");
        logger.debug(model.toString());
        return model;
    }

}
