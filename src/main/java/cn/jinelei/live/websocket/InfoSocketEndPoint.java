package cn.jinelei.live.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by jinelei on 17-3-30.
 */
@Component
public class InfoSocketEndPoint extends TextWebSocketHandler {
    private static final Logger logger = LoggerFactory.getLogger(InfoSocketEndPoint.class);
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        logger.debug(message.getPayload());
        TextMessage textMessage = new TextMessage(message.getPayload()+" received at server");
        session.sendMessage(textMessage);
    }
}
