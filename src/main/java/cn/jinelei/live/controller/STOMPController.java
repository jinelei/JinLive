package cn.jinelei.live.controller;

import cn.jinelei.live.model.Shout;
import cn.jinelei.live.model.nginx.Application;
import cn.jinelei.live.model.nginx.RTMP;
import cn.jinelei.live.model.nginx.live.Live;
import cn.jinelei.live.model.nginx.vod.Vod;
import cn.jinelei.live.utils.handler.EntityHandler;
import cn.jinelei.live.utils.net.HttpTools;
import cn.jinelei.live.utils.rtmp.RTMPCacheManager;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
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

    public SimpMessagingTemplate template;

    @Autowired
    public STOMPController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/msg")
    @SendTo("/topic/msg")
    public String handleMessage(String msg) {
        logger.debug("load msg: " + msg);
        return "recived msg: " + msg;
    }

//    @SubscribeMapping("/msg")
//    public String subscriptRoom() {
//        logger.debug("handle scription room");
//        return "room";
//    }

    @MessageMapping("/message")
    @SendToUser("/message")
    public String userMessage(String msg){
        return msg;
    }

}
