package com.lhalj.spring.escape.application_context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

/**
 * 描述: 监听器获取应用上下文
 */
@Slf4j
//@Component
public class UseListener implements ApplicationListener<ApplicationContextEvent> {
    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {

        //断言
        assert ApplicationContextStore.getApplicationContext() == null;
        //应用上下文
        ApplicationContextStore.setApplicationContext(event.getApplicationContext());
        //断言
        assert ApplicationContextStore.getApplicationContext() != null;

        log.info("UseListener Done.");
    }
}
