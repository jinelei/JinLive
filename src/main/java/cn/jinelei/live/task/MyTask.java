package cn.jinelei.live.task;

import cn.jinelei.live.utils.UpdateRTMP;
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
    public void updateRTMP() {
        UpdateRTMP.updateRTMP();
    }

}
