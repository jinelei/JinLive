package cn.jinelei.live.utils.websocket.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by jinelei on 17-5-5.
 */
public class ChatHandler extends TextWebSocketHandler{

    private static final Logger logger = LoggerFactory.getLogger(ChatHandler.class);

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        logger.info(String.format("message: %s\t\t length: %d",message.getPayload(),message.getPayloadLength()));
    }
}
