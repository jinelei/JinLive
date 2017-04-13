package cn.jinelei.live.controller;

import cn.jinelei.live.exception.UserException;
import cn.jinelei.live.model.data.User;
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
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/request/{method}", method = RequestMethod.GET)
    public ModelAndView requestAuthrize(@PathVariable(value = "method") String method) {
        ModelAndView model = new ModelAndView("request");
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (object instanceof String) {
            model.addObject("status", 1);
        } else {
            model.addObject("status", 0);
        }
        if("anchor".equals(method)){
            model.setViewName("roomset");
        }
        logger.debug(model.toString());
        return model;
    }

    @ResponseBody
    @RequestMapping(value = "/request/{method}", method = RequestMethod.POST)
    public String handleRequest(@PathVariable(value = "method") String method,
                                @RequestParam(required = false, value = "phone") String phone,
                                @RequestParam(required = false, value = "email") String email) {
        JsonObject jsonObject = new JsonObject();
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (object instanceof String) {
            jsonObject.addProperty("status", 1);
        } else {
            User user = (User) object;
            user.setUserPhone(phone);
            user.setUserEmail(email);
            Integer status = user.getUserStatus();
            if ("active".equals(method)) {
                user.setUserStatus(status ^ Integer.valueOf(UserStatus.INACTIVE.toString()) | Integer.valueOf(UserStatus.ACTIVE.toString()));
            } else if ("lock".equals(method)) {
                user.setUserStatus(status ^ Integer.valueOf(UserStatus.LOCKED.toString()));
            }
            try {
                userService.updateUser(user);
                jsonObject.addProperty("status", 0);
            } catch (UserException e) {
                jsonObject.addProperty("status", 1);
            }
        }
        logger.debug(jsonObject.toString());
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String userUpdate(@RequestParam(value = "userid", required = false) Integer userid,
                             @RequestParam(value = "type", required = false) String type,
                             @RequestParam(value = "value", required = false) String value) {
        JsonObject jsonObject = new JsonObject();
        try {
            User user = userService.getUserInfo(userid);
            boolean res;
            if ("nickname".equals(type)) {
                user.setUserNickname(value);
            } else if ("sex".equals(type)) {
                user.setUserSex(Integer.valueOf(value));
            } else if ("age".equals(type)) {
                user.setUserAge(Integer.valueOf(value));
            } else if ("height".equals(type)) {
                user.setUserHeight(Integer.valueOf(value));
            } else if ("weight".equals(type)) {
                user.setUserWeight(Integer.valueOf(value));
            } else if ("email".equals(type)) {
                user.setUserEmail(value);
            } else if ("password".equals(type)) {
                user.setUserPasswd(value);
            } else if ("phone".equals(type)) {
                user.setUserPhone(value);
            }
            res = userService.updateUser(user);
            jsonObject.addProperty("status", res ? 0 : 1);
        } catch (UserException e) {
            jsonObject.addProperty("status", 1);
        }
        logger.debug(jsonObject.toString());
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/exist/name/{name}", method = RequestMethod.GET)
    public String userIsExist(@PathVariable(value = "name", required = false) String name) {
        JsonObject jsonObject = new JsonObject();
        try {
            User user = userService.getUserInfo(name.trim());
            jsonObject.addProperty("status", 1);
        } catch (UserException e) {
            if (e.getMessage().equals(UserException.USER_NOT_EXIST))
                jsonObject.addProperty("status", 0);
            else
                jsonObject.addProperty("status", 1);
        }
        logger.debug(jsonObject.toString());
        return jsonObject.toString();
    }

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

    @ResponseBody
    @RequestMapping(value = "/registerAjax", method = RequestMethod.POST)
    public String registerAjaxPost(@RequestParam(value = "username", required = false) String username,
                                   @RequestParam(value = "password", required = false) String password,
                                   @RequestParam(value = "phone", required = false) String phone,
                                   @RequestParam(value = "age", required = false) Integer age,
                                   @RequestParam(value = "sex", required = false) Integer sex,
                                   HttpServletRequest request) {
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        try {
            User user1 = userService.register(username, sex, age, password, phone);
            jsonObject.addProperty("status", "0");
        } catch (UserException e) {
            jsonObject.addProperty("status", "1");
            if (e.getMessage().equals(UserException.USER_NOT_EXIST))
                jsonObject.addProperty("errorCode", UserException.USER_NOT_EXIST);
            else if (e.getMessage().equals(UserException.USER_NOT_UNIQUE))
                jsonObject.addProperty("errorCode", UserException.USER_NOT_UNIQUE);
            else if (e.getMessage().equals(UserException.USER_WAS_EXIST))
                jsonObject.addProperty("errorCode", UserException.USER_WAS_EXIST);
        }
        logger.debug(jsonObject.toString());
        return jsonObject.toString();
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ModelAndView userinfo(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("userinfo");
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            if (object instanceof String) {
                model.addObject("status", 2);
            } else {
                User user = userService.getUserInfo(((User) object).getUserId());
                model.addObject("user", user);
                model.addObject("status", 0);
            }
        } catch (UserException e) {
            model.addObject("status", 1);
        }
        logger.debug(model.toString());
        return model;
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ModelAndView userinfo(@PathVariable(value = "id") Integer userId, HttpServletRequest request) {
        ModelAndView model = new ModelAndView("anchorinfo");
        try {
            User user = userService.getUserInfo(userId);
            model.addObject("user", user);
            model.addObject("status", 0);
        } catch (UserException e) {
            model.addObject("status", 1);
        }
        logger.debug(model.toString());
        return model;
    }
}
