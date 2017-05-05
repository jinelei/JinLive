package cn.jinelei.live.config.stomp;

import cn.jinelei.live.websocket.ChatHandler;
import cn.jinelei.live.websocket.ChatHandshakeInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.*;

/**
 * Created by jinelei on 17-4-11.
 */
@Configuration
@EnableWebSocketMessageBroker
public class MyStompConfig extends AbstractWebSocketMessageBrokerConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(MyStompConfig.class);

    @Bean
    public ChatHandler chatHandler() {
        return new ChatHandler();
    }

    @Bean
    public ChatHandshakeInterceptor chatHandshakeInterceptor() {
        return new ChatHandshakeInterceptor();
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/chat")
                .setAllowedOrigins("*")
                .addInterceptors(chatHandshakeInterceptor())
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/queue", "/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }

}
