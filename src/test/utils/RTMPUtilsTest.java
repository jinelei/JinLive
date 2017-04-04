package utils;

import cn.jinelei.live.model.nginx.RTMP;
import cn.jinelei.live.utils.rtmp.RTMPUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by jinelei on 17-4-3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:live-servlet.xml"})
public class RTMPUtilsTest {

    private static final Logger logger = LoggerFactory.getLogger(RTMPUtilsTest.class);

    @Autowired
    private RTMPUtils rtmpUtils;

    @Test
    public void getRTMPInfoFromServer() {
        RTMP rtmp = rtmpUtils.getRTMPInfoFromServer();
        logger.debug(rtmp.toString());
        assert rtmp != null;
    }

    @Test
    public void saveScreenShot(){
        RTMP rtmp = rtmpUtils.getRTMPInfoFromServer();
        assert rtmp != null;
        rtmpUtils.getScreenShotFromLiveStream(rtmpUtils.getLiveStreamFromRTMP(rtmp));
    }

}
