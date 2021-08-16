package com.lhalj.spring.escape.filter_and_interceptor;

import com.lhalj.spring.escape.http_request_response.UserIdInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 描述:
 */
@Component
@Configuration
public class WebInterceptorAdapter implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**").order(0);
        registry.addInterceptor(new UpdateInterceptor()).addPathPatterns("/**").order(1);
        registry.addInterceptor(new UserIdInterceptor()).addPathPatterns("/**").order(2);
    }
}
