package cn.jinelei.live.task;

import cn.jinelei.live.utils.rtmp.RTMPCache;
import cn.jinelei.live.utils.rtmp.RTMPUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by jinelei on 17-3-27.
 */
@Component
@Lazy(value = false)
public class MyTask {

    @Autowired
    private RTMPCache rtmpCache;

    @Autowired
    private RTMPUtils rtmpUtils;

    private static final Logger logger = LoggerFactory.getLogger(MyTask.class);

    @Scheduled(cron = "*/5 * * * * ?")//每隔5秒执行一次
    public void updateRTMP() {
        logger.info("定时任务： 刷新缓存：rtmpCache");
        rtmpCache.setRtmpMap(rtmpUtils.updateRTMP());
    }

}
