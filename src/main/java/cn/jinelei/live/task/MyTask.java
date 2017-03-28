package cn.jinelei.live.task;

import cn.jinelei.live.model.nginx.RTMP;
import cn.jinelei.live.utils.UpdateRTMP;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.store.ElementIdAssigningStore;
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
    private CacheManager cacheManager;

    private static final Logger logger = LoggerFactory.getLogger(MyTask.class);


    @Scheduled(cron = "*/5 * * * * ?")//每隔5秒执行一次
    public void updateRTMP() {
        RTMP rtmp = UpdateRTMP.updateRTMP();
        Cache cache = new Cache("rtmpCache", 5000, true, true, 36000, 36000);
        cache.put(new Element("rtmp", rtmp));
        cacheManager.addCache(cache);
    }

    @Scheduled(cron = "*/6 * * * * ?")//每隔5秒执行一次
    public void getRTMP() {
        Cache cache = cacheManager.getCache("rtmpCache");
        Element element = cache.get("rtmp");
        Object o = element.getValue();
        logger.debug(((RTMP)o).getServer().toString());


    }


}
