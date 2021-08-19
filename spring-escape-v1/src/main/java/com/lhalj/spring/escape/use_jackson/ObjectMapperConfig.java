package com.lhalj.spring.escape.use_jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 描述:
 */
@Configuration
public class ObjectMapperConfig {

    @Bean
    @Primary
    public ObjectMapper objectMapper(){
        ObjectMapper mapper = new ObjectMapper();

        //忽略 json字符串中不识别字段
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);


        return mapper;
    }

}
