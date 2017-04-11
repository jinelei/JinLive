package cn.jinelei.live.config;

import cn.jinelei.live.websocket.HandshakeInterceptor;
import cn.jinelei.live.websocket.MyHandshakeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by jinelei on 17-4-11.
 */
@Configuration
@EnableWebSocketMessageBroker
public class MyStompConfig extends AbstractWebSocketMessageBrokerConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(MyStompConfig.class);
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        logger.debug("add endpoint");
        stompEndpointRegistry.addEndpoint("/msgservice")
                .setAllowedOrigins("*")
                .setHandshakeHandler(new MyHandshakeHandler())
                .addInterceptors(new HandshakeInterceptor()).withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        logger.debug("registry");
        registry.enableSimpleBroker("/topic", "/user");
        registry.setApplicationDestinationPrefixes("/app");
        registry.setUserDestinationPrefix("/user/");
    }

}
