package cn.jinelei.live.config.viewer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by jinelei on 17-4-3.
 */
public class MyFreeMarkerView extends FreeMarkerView {

    private static Logger logger = LoggerFactory.getLogger(MyFreeMarkerView.class);

    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        logger.debug("map: " + model);
        ResourceBundle resource = ResourceBundle.getBundle("application");
        model.put("tomcat_server", resource.getString("tomcat_server"));
        model.put("nginx_server", resource.getString("nginx_server"));
        model.put("application_name", resource.getString("application_name"));
        super.exposeHelpers(model, request);
    }
}
