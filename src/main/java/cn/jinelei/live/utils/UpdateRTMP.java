package cn.jinelei.live.utils;

import cn.jinelei.live.handler.JinStreamHandler;
import cn.jinelei.live.model.nginx.RTMP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachePut;

/**
 * Created by jinelei on 17-3-27.
 */
public class UpdateRTMP {

    private static final Logger logger = LoggerFactory.getLogger(UpdateRTMP.class);

//    @CachePut(value = "rtmp",key = "rtmp",cacheNames = "rtmp",cacheManager = "rtmp")
    public static RTMP updateRTMP(){
        logger.debug("-----------update RTMP task: start update rtmp-------------");
        String url = "http://192.168.31.111/stat";
        RTMP rtmp = JinStreamHandler.handleEntity(HttpTools.getEntity(url));
        logger.debug("-----------update RTMP task: stop update rtmp-------------");
        return rtmp;
    }
}
