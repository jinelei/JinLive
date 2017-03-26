package cn.jinelei.live.controller;

import cn.jinelei.live.handler.JinStreamHandler;
import cn.jinelei.live.model.nginx.RTMP;
import cn.jinelei.live.utils.HttpTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = {"/index", "/"})
    public String index() {
        logger.debug("index debug");
        return "index";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String test(ModelMap model) {
//        model.addAttribute("msg", environment.getProperty("server_ip"));
        String url = "http://192.168.31.111/stat";
        RTMP rtmp = JinStreamHandler.handleEntity(HttpTools.getEntity(url));
        logger.debug(rtmp.toString());
        model.addAttribute("rtmp", rtmp);
        return "information";
    }


}
