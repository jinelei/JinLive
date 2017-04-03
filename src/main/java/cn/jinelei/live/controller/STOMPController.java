package cn.jinelei.live.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;


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
//    @SendTo("/topic/msg")
    public void handleMessage(@Headers Map<String, Object> headers, @Payload String msg) {
        Map<String, Object> map = (Map<String, Object>) headers.get("nativeHeaders");
        String room_id = (String) ((List<String>) map.get("room_id")).get(0);
        logger.debug("room_id", room_id);
        template.convertAndSend("/topic/msg/" + room_id, "return: " + msg, headers);
    }

    @MessageMapping("/message")
    @SendToUser("/message")
    public String userMessage(String msg) {
        return msg;
    }

}
