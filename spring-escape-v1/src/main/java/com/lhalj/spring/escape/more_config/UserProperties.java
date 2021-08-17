package com.lhalj.spring.escape.more_config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 描述:
 */
@Data
@ToString
@Component
@ConfigurationProperties(prefix = "ecsape.user")
public class UserProperties {

    private String name;
    private Integer age;

}
