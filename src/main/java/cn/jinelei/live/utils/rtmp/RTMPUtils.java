package cn.jinelei.live.utils.rtmp;

import cn.jinelei.live.model.nginx.RTMP;
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
        String url = environment.getProperty("server_ip");
        String statUrl = String.format("http://%s/stat", url);
        RTMP rtmp = entityHandler.handleEntity(httpTools.getEntity(statUrl));
        return rtmp;
    }

    public Map<String, String> getScreenShotFromLiveStream(List<Stream> streamList) {
        Map<String, String> streamMap = new HashMap<>(32);
        streamList.stream().forEach((Stream stream) -> {
            String baseDir = "/usr/local/nginx/html/screenshot/";
            String cmd1 = String.format("rm -rf %s%s.png", baseDir, stream.getName());
            String cmd2 = String.format("ffmpeg -i rtmp://%s:1935/%s/%s -vframes 1 %s%s.png",
                    environment.getProperty("server_ip"),
                    environment.getProperty("app_name"),
                    stream.getName(),
                    baseDir,
                    stream.getName());
            String cmd3 = String.format("curl -F 'filename=@%s%s.png' http://%s:8080/%s/fileupload",
                    baseDir,
                    stream.getName(),
                    environment.getProperty("server_ip"),
                    environment.getProperty("app_name"));
            executor.submit(() -> {
                try {
                    Runtime runtime = Runtime.getRuntime();
//                    logger.debug("start exec cmd: " + cmd);
                    logger.debug("cmd2");
                    runtime.exec(cmd2);
                    logger.debug("cmd3");
                    runtime.exec(cmd3);
                    logger.debug("cmd1");
                    runtime.exec(cmd1);
//                    logger.debug("stop exec cmd: " + cmd);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });
        return streamMap;
    }


}
