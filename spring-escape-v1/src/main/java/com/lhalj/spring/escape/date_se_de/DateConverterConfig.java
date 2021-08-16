package com.lhalj.spring.escape.date_se_de;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;

/**
 * 描述: 全局反序列化
 */
@Configuration
public class DateConverterConfig {

    @Bean
    public DateJacksonConverter dateJacksonConverter(){
        return new DateJacksonConverter();
    }

    @Bean
    public Jackson2ObjectMapperFactoryBean jackson2ObjectMapperFactoryBean(
            @Autowired DateJacksonConverter dateJacksonConverter
    ){
        // Jackson自己的反序列化实现
        Jackson2ObjectMapperFactoryBean jackson2ObjectMapperFactoryBean = new Jackson2ObjectMapperFactoryBean();
        //反序列化
        jackson2ObjectMapperFactoryBean.setDeserializers(dateJacksonConverter);

        return jackson2ObjectMapperFactoryBean;

    }

}
