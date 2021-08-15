package com.lhalj.spring.escape.application_context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 描述: 第一种方式获取应用上下文
 */
@Slf4j
public class UseIntitiallizer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        //断言
        assert ApplicationContextStore.getApplicationContext() == null;
        //应用上下文
        ApplicationContextStore.setApplicationContext(applicationContext);
        //断言
        assert ApplicationContextStore.getApplicationContext() != null;

        log.info("UseIntitiallizer Done.");

    }
}
