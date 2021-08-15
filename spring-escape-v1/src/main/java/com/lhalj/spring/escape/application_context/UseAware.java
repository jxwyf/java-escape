package com.lhalj.spring.escape.application_context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 描述:ApplicationContextAware Spring的Aware接口
 */
@Slf4j
@Component
public class UseAware implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {


        //断言
        assert ApplicationContextStore.getApplicationContext() == null;
        //应用上下文
        ApplicationContextStore.setApplicationContext(applicationContext);
        //断言
        assert ApplicationContextStore.getApplicationContext() != null;

        log.info("UseAware Done.");

    }
}
