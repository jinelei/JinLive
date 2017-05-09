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
}
