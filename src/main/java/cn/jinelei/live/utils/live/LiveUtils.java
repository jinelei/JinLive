package cn.jinelei.live.utils.live;

import cn.jinelei.live.model.nginx.RTMP;
import cn.jinelei.live.model.nginx.live.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinelei on 17-4-6.
 */
@PropertySource("classpath:/application.properties")
public class LiveUtils {

    private static final Logger logger = LoggerFactory.getLogger(LiveUtils.class);

    public List<String> getLiveStreamKey(List<Stream> streamList) {
        List<String> aliveStreamList = new ArrayList<>(32);
        for (Stream stream: streamList) {
            aliveStreamList.add(stream.getName());
        }
        return aliveStreamList;
    }

}
