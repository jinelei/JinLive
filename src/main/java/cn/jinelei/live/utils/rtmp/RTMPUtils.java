package cn.jinelei.live.utils.rtmp;

import cn.jinelei.live.model.nginx.Application;
import cn.jinelei.live.model.nginx.RTMP;
import cn.jinelei.live.model.nginx.live.Live;
import cn.jinelei.live.model.nginx.live.Stream;
import cn.jinelei.live.utils.net.handler.EntityHandler;
import cn.jinelei.live.utils.net.HttpTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    @Value("${nginx_server}")
    private String nginx_server;
    @Value("${tomcat_server}")
    private String tomcat_server;
    @Value("${application_name}")
    private String application_name;
    @Value("${screenshot_dir}")
    private String screenshot_dir;

    private static ExecutorService executor = Executors.newCachedThreadPool();

    public RTMP getRTMPInfoFromServer() {
        String statUrl = String.format("%s/stat", nginx_server);
        RTMP rtmp = entityHandler.handleEntity(httpTools.getEntity(statUrl));
        return rtmp;
    }

    public List<Stream> getLiveStreamFromRTMP(RTMP rtmp) {
        List<Stream> streamList = null;
        if (rtmp != null) {
            for (Application application : rtmp.getServer().getApplications()) {
                if ("live".equals(application.getName())) {
                    streamList = ((Live) application).getStreams();
                }
            }
        }
        return streamList;
    }

    public void getScreenShotFromLiveStream(List<String> streamList) {
        streamList.forEach(stream -> {
            String touch_file = String.format("ffmpeg -re -i rtmp://%s:1935/stream/%s -an -y -f image2 -r 1 %s%s.jpg",
                    nginx_server.substring(nginx_server.indexOf(':') + 3), stream, screenshot_dir, stream);
            logger.debug(touch_file);
            executor.submit(() -> {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    runtime.exec(touch_file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });
    }


}
