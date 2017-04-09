import cn.jinelei.live.model.nginx.RTMP;
import cn.jinelei.live.utils.rtmp.RTMPUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * Created by jinelei on 17-4-3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/live-servlet.xml"})
@WebAppConfiguration
public class RTMPUtilsTest {
//
//    private static final Logger logger = LoggerFactory.getLogger(RTMPUtilsTest.class);
//    @Autowired
//    private WebApplicationContext wac;
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//    }
//
//    @Autowired
//    private RTMPUtils rtmpUtils;
//
//    @Test
//    public void getRTMPInfoFromServer() {
//        RTMP rtmp = rtmpUtils.getRTMPInfoFromServer();
//        logger.debug(rtmp.toString());
//        assert rtmp != null;
//    }
//
//    @Test
//    public void saveScreenShot() {
//        RTMP rtmp = rtmpUtils.getRTMPInfoFromServer();
//        assert rtmp != null;
//        rtmpUtils.getScreenShotFromLiveStream(rtmpUtils.getLiveStreamFromRTMP(rtmp));
//    }

}
