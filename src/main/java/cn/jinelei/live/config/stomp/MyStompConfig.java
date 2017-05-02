package cn.jinelei.live.config.stomp;

import cn.jinelei.live.websocket.ChatHandler;
import cn.jinelei.live.websocket.ChatHandshakeInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.*;

/**
 * Created by jinelei on 17-4-11.
 */
@Configuration
@EnableWebSocketMessageBroker
@EnableWebMvc
public class MyStompConfig implements WebSocketConfigurer{

    private static final Logger logger = LoggerFactory.getLogger(MyStompConfig.class);

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(chatHandler(), "/chat").setAllowedOrigins("*").addInterceptors(chatHandshakeInterceptor());
        webSocketHandlerRegistry.addHandler(chatHandler(),"/sockjs/chat").setAllowedOrigins("*").addInterceptors(chatHandshakeInterceptor()).withSockJS();
    }

    @Bean
    public ChatHandler chatHandler(){
        return new ChatHandler();
    }

    @Bean
    public ChatHandshakeInterceptor chatHandshakeInterceptor(){
        return new ChatHandshakeInterceptor();
    }
}