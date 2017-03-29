package cn.jinelei.live.config;

import cn.jinelei.live.websocket.LiveMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by jinelei on 17-3-29.
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketConfig.class);

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        logger.debug("registerWebSocketHandlers");
        webSocketHandlerRegistry.addHandler(liveMessageHandler(),"/msg");
    }

    @Bean
    public LiveMessageHandler liveMessageHandler(){
        logger.debug("LiveMessageHandler");
        return new LiveMessageHandler();
    }
}
