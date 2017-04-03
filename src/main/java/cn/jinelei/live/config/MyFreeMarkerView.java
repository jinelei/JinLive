package cn.jinelei.live.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by jinelei on 17-4-3.
 */
@PropertySource("classpath:/application.properties")
public class MyFreeMarkerView extends FreeMarkerView {

    @Autowired
    private Environment environment;

    private static Logger logger = LoggerFactory.getLogger(MyFreeMarkerView.class);

    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        model.put("tomcat_server_ip",environment.getProperty("tomcat_server_ip"));
        model.put("tomcat_proxy_server_ip",environment.getProperty("tomcat_proxy_server_ip"));
        model.put("nginx_server_ip",environment.getProperty("nginx_server_ip"));
        model.put("application_name",environment.getProperty("application_name"));
        super.exposeHelpers(model, request);
    }
}
