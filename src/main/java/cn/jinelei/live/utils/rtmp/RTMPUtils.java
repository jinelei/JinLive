package cn.jinelei.live.utils.rtmp;

import cn.jinelei.live.utils.handler.EntityHandler;
import cn.jinelei.live.model.nginx.RTMP;
import cn.jinelei.live.utils.net.HttpTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by jinelei on 17-3-27.
 */
@PropertySource("classpath:/application.properties")
public class RTMPUtils {

    private static final Logger logger = LoggerFactory.getLogger(RTMPUtils.class);

    @Autowired
    private Environment environment;
    @Autowired
    private EntityHandler entityHandler;
    @Autowired
    private HttpTools httpTools;

    public RTMP updateRTMP() {
        String url = environment.getProperty("server_ip");
        String statUrl = String.format("http://%s/stat", url);
        RTMP rtmp = entityHandler.handleEntity(httpTools.getEntity(statUrl));
        return rtmp;
    }
}
