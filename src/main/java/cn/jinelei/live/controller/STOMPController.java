package cn.jinelei.live.controller;

import cn.jinelei.live.model.data.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/**
 * Created by jinelei on 17-3-26.
 */
@Controller
@PropertySource("classpath:/application.properties")
public class STOMPController {

    private static final Logger logger = LoggerFactory.getLogger(STOMPController.class);

//    public SimpMessagingTemplate template;
//
//    @Autowired(required = false)
//    public STOMPController(SimpMessagingTemplate template) {
//        this.template = template;
//    }

//    @MessageMapping("/msg")
//    public void handleMessage(@Headers Map<String, Object> headers, @Payload String msg) {
//        Map<String, Object> map = (Map<String, Object>) headers.get("nativeHeaders");
//        String room_id = (String) ((List<String>) map.get("room_id")).get(0);
//        logger.debug("room_id", room_id);
//        User user = (User) ((UsernamePasswordAuthenticationToken) headers.get("simpUser")).getPrincipal();
//        logger.debug(user.getUserName());
//        template.convertAndSend("/topic/msg/" + room_id, String.format("%s: %s", user.getUsername(), msg), headers);
//    }

    @MessageMapping("/message")
    @SendToUser("/message")
    public String userMessage(String msg) {
        logger.debug(msg);
        return msg;
    }

}
