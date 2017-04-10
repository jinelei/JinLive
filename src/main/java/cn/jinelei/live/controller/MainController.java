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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
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
    @Autowired
    private UserDetailsService userDetailsService;

    @Value("${tomcat_server_ip}")
    private String tomcat_server_ip;

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
        String url = environment.getProperty("server_ip");
        model.addAttribute("server_ip", url);
        model.addAttribute("stream_key", streamKey);
        logger.debug(model.toString());
        return "room";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(@RequestParam(value = "username", required = false) String username,
                            @RequestParam(value = "password", required = false) String password) {
        return "forword:/live/loginAjax";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        ModelMap model,
                        HttpServletRequest request) {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        logger.debug(user.toString());
        if (!user.toString().equals("anonymousUser"))
            return "redirect:/live/index";
        logger.debug("login get");
        boolean isAjax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
        logger.debug("is ajax: " + isAjax);
        if (isAjax)
            return "forward:/loginAjax";
        else
            return "login";
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
//                Authentication token = new UsernamePasswordAuthenticationToken(username, password);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetailsService.loadUserByUsername(user.getUserName()), password, grantedAuthorities);
                authentication.setDetails(new WebAuthenticationDetails(request));

                logger.debug(authentication.toString());

                SecurityContextHolder.getContext().setAuthentication(authentication);
                String userName = SecurityContextHolder.getContext().getAuthentication().getName();
                jsonObject.addProperty("status", "0");
//                jsonObject.addProperty("user", gson.toJson(userDetails));
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

}
