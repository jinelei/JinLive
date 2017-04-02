package cn.jinelei.live.config;

import cn.jinelei.live.websocket.HandshakeInterceptor;
import cn.jinelei.live.websocket.SystemWebSocketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

/**
 * Created by jinelei on 17-3-30.
 */
@Configuration
//@EnableWebSocket
//@EnableWebMvc
@EnableWebSocketMessageBroker
public class SocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

    private static final Logger logger = LoggerFactory.getLogger(SocketConfig.class);

//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
//        webSocketHandlerRegistry.addHandler(systemWebSocketHander(),"/websck").addInterceptors(new HandshakeInterceptor());
//        logger.debug("register");
//        webSocketHandlerRegistry.addHandler(systemWebSocketHander(),"/socketjs/websck/info").addInterceptors(new HandshakeInterceptor()).withSockJS();
//    }

    @Bean
    public WebSocketHandler systemWebSocketHander() {
        return new SystemWebSocketHandler();
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/msg").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/queue","topic");
//        registry.enableStompBrokerRelay("/queue","topic");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
