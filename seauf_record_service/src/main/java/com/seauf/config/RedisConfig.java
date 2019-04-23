package com.seauf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;


/**
 * Redis缓存配置类
 *
 * @author lynn
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.timeout}")
    private int timeout;

    @Bean
    public RedisConnectionFactory redisCF(){
        //如果什么参数都不设置，默认连接本地6379端口
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setPort(6379);
        factory.setHostName("localhost");
        return factory;
    }
}