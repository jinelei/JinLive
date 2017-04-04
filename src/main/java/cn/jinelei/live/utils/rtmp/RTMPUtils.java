package cn.jinelei.live.utils.rtmp;

import cn.jinelei.live.model.nginx.Application;
import cn.jinelei.live.model.nginx.RTMP;
import cn.jinelei.live.model.nginx.live.Live;
import cn.jinelei.live.model.nginx.live.Stream;
import cn.jinelei.live.utils.handler.EntityHandler;
import cn.jinelei.live.utils.net.HttpTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private static ExecutorService executor = Executors.newCachedThreadPool();

    public RTMP getRTMPInfoFromServer() {
        String url = environment.getProperty("nginx_server_ip");
        String statUrl = String.format("%s/stat", url);
//        logger.debug("stat url: " + statUrl);
        RTMP rtmp = entityHandler.handleEntity(httpTools.getEntity(statUrl));
        return rtmp;
    }

    public List<Stream> getLiveStreamFromRTMP(RTMP rtmp){
        List<Stream> streamList = null;
        if (rtmp != null) {
            for (Application application: rtmp.getServer().getApplications()){
                if ("live".equals(application.getName())) {
                   streamList = ((Live) application).getStreams();
                }
            }
        }
        return streamList;
    }

    public Map<String, String> getScreenShotFromLiveStream(List<Stream> streamList) {
        Map<String, String> streamMap = new HashMap<>(32);
        streamList.stream().forEach((Stream stream) -> {
            String nginx_server_ip = environment.getProperty("nginx_server_ip");
            String tomcat_proxy_server_ip = environment.getProperty("nginx_server_ip");
            String application_name = environment.getProperty("application_name");
            String baseDir = "/usr/local/nginx/html/screenshot/";
            String cmd1 = String.format("rm -rf %s%s.png", baseDir, stream.getName());
            String cmd2 = String.format("ffmpeg -i rtmp://%s:1935/%s/%s -vframes 1 %s%s.png",
                    nginx_server_ip, application_name, stream.getName(), baseDir, stream.getName());
            String cmd3 = String.format("curl -F 'filename=@%s%s.png' http://%s/%s/fileupload",
                    baseDir, stream.getName(), tomcat_proxy_server_ip,application_name );
            executor.submit(() -> {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    logger.debug("save photo");
                    runtime.exec(cmd2);
                    logger.debug("curl");
                    runtime.exec(cmd3);
                    logger.debug("rm");
                    runtime.exec(cmd1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });
        return streamMap;
    }

}
