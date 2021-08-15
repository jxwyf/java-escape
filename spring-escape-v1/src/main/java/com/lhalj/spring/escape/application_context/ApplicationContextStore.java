package com.lhalj.spring.escape.application_context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

/**
 * 描述:保存应用上下文
 */
@Slf4j
public class ApplicationContextStore {

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext){
        log.info("Coming In ApplicationContextStore!");
        ApplicationContextStore.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return ApplicationContextStore.applicationContext;
    }
}
