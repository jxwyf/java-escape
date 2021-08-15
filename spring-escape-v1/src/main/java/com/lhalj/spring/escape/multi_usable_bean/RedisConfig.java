package com.lhalj.spring.escape.multi_usable_bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 描述:配置多个 Redis数据源
 */
@Configuration
public class RedisConfig {


    private final RedisConnectionFactory redisConnectionFactory;

    @Autowired
    public RedisConfig(RedisConnectionFactory redisConnectionFactory){
        this.redisConnectionFactory = redisConnectionFactory;
    }

    @Bean(name = "fyRedisTemplate")
    public RedisTemplate<String, Object> getFyRedisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        //序列化
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();

        //Jdk序列化策略
        JdkSerializationRedisSerializer redisSerializer = new JdkSerializationRedisSerializer();

        //设置连接工厂 与redis建立连接
        template.setConnectionFactory(factory);
        template.setKeySerializer(stringSerializer);
        template.setValueSerializer(redisSerializer);

        return template;
    }


    @Bean(name = "imoocRedisTemplate")
    @Primary
    public RedisTemplate<String, Object> getImoocRedisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        //序列化 把key和value都序列化成字符串
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();

        //设置连接工厂 与redis建立连接
        template.setConnectionFactory(factory);
        template.setKeySerializer(stringSerializer);
        template.setValueSerializer(stringSerializer);

        return template;
    }
}
