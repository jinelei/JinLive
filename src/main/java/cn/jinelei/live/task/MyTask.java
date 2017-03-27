package cn.jinelei.live.task;

import cn.jinelei.live.handler.JinStreamHandler;
import cn.jinelei.live.model.nginx.RTMP;
import cn.jinelei.live.utils.HttpTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by jinelei on 17-3-27.
 */
@Component
@Lazy(value = false)
public class MyTask {

    private static final Logger logger = LoggerFactory.getLogger(MyTask.class);

    @Scheduled(cron = "*/5 * * * * ?")//每隔5秒执行一次
    public void updateRTMP(){
        logger.debug("-----------update RTMP task: start update rtmp-------------");
        String url = "http://192.168.31.111/stat";
        RTMP rtmp = JinStreamHandler.handleEntity(HttpTools.getEntity(url));
        logger.debug("-----------update RTMP task: stop update rtmp-------------");
    }

}
