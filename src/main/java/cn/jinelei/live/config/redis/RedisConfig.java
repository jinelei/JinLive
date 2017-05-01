package cn.jinelei.live.config.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by jinelei on 17-4-9.
 */
@Configuration
@EnableRedisHttpSession
public class RedisConfig {
    @Bean
    public JedisConnectionFactory connectionFactory() {
        final JedisConnectionFactory connection = new JedisConnectionFactory();
        connection.setHostName("localhost");
        connection.setPort(6379);
        return connection;
    }
}
