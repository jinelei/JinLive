package cn.jinelei.live.utils.rtmp;

import cn.jinelei.live.model.nginx.RTMP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by jinelei on 17-3-28.
 */
public class RTMPCache {
    private static final Logger logger = LoggerFactory.getLogger(RTMPCache.class);
    private Queue<RTMP> rtmpQueue = new ArrayBlockingQueue<RTMP>(1);

    public void setRtmpMap(RTMP rtmp) {
        if (rtmpQueue.size() > 0) {
            rtmpQueue.remove();
        }
        rtmpQueue.add(rtmp);
    }

    public RTMP getRTMP() {
        RTMP rtmp = rtmpQueue.peek();
        return rtmp;
    }
}
