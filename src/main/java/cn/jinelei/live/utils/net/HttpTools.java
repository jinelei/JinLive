package cn.jinelei.live.utils.net;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by jinelei on 17-3-26.
 */
public class HttpTools {

    private static final Logger logger = LoggerFactory.getLogger(HttpTools.class);

    public HttpEntity getEntity(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        try {
            response = httpclient.execute(httpget);
            entity = response.getEntity();
            logger.debug("entity: " + entity.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entity;
    }

}
