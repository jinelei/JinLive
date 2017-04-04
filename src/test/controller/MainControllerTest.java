import cn.jinelei.live.model.nginx.RTMP;
import cn.jinelei.live.utils.rtmp.RTMPCacheManager;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by jinelei on 17-4-3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:live-servlet.xml"})
@WebAppConfiguration
public class MainControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(MainControllerTest.class);
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    @Autowired
    private RTMPUtils rtmpUtils;
    @Autowired
    private RTMPCacheManager rtmpCacheManager;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void index() throws Exception {
        RTMP rtmp = rtmpUtils.getRTMPInfoFromServer();
        rtmpCacheManager.setRtmpMap(rtmp);
        mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(model().attribute("message", "Hello Reader!"))
                .andExpect(view().name("index"));
    }

    @Test
    public void room() throws Exception {
        mockMvc.perform(post("/room")
                .param("stream_id", "video0"))
//                .andDo(print())
                .andExpect(view().name("room"));
    }


}
