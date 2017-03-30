package cn.jinelei.live.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

/**
 * Created by jinelei on 17-3-30.
 */
@Component
public class SystemWebSocketHandler implements WebSocketHandler {

    private static final Logger logger = LoggerFactory.getLogger(SystemWebSocketHandler.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        logger.debug("Server:connected OK!");
        webSocketSession.sendMessage(new TextMessage("Server:connected OK!"));
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        TextMessage returnMessage = new TextMessage(webSocketMessage.getPayload()
                + " received at server");
        webSocketSession.sendMessage(returnMessage);
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        if(webSocketSession.isOpen()){
            webSocketSession.close();
        }
        logger.debug("websocket connection closed......");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        logger.debug("websocket connection closed......");
    }

    @Override
    public boolean supportsPartialMessages() {
        return true;
    }
}
