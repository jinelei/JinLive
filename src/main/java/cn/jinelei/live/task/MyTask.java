package cn.jinelei.live.task;

import cn.jinelei.live.model.nginx.RTMP;
import cn.jinelei.live.model.nginx.live.Live;
import cn.jinelei.live.utils.rtmp.LiveUtils;
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
    private LiveUtils liveUtils;

    private static final Logger logger = LoggerFactory.getLogger(MyTask.class);

    @Scheduled(cron = "*/5 * * * * ?")//每隔5秒执行一次
    public void updateRTMPCache() {
        logger.info("定时任务： 刷新缓存");
        RTMP rtmp = liveUtils.getRTMPInfoFromServer();
        rtmp.getServer().getApplications().stream().forEach(application -> {
            if ("live".equals(application.getName())) {
                liveUtils.updateRoomStatus(((Live) application).getStreams());
            }
        });
    }

    @Scheduled(cron = "*/60 * * * * ?")//每隔60秒执行一次
    public void getScreenShotFromStream() {
        logger.info("定时任务： 刷新截图");
        RTMP rtmp = liveUtils.getRTMPInfoFromServer();
        rtmp.getServer().getApplications().stream().forEach(application -> {
            if ("live".equals(application.getName())) {
                liveUtils.grabScreenshots(((Live) application).getStreams());
            }
        });
    }

}
