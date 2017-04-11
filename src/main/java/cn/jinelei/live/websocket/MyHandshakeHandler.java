package cn.jinelei.live.websocket;

import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

/**
 * Created by jinelei on 17-4-11.
 */
public class MyHandshakeHandler extends DefaultHandshakeHandler{
    {
        System.out.println("MyHandshakeHandler init");
    }
}
