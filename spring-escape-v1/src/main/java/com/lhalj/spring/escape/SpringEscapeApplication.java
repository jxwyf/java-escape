package com.lhalj.spring.escape;

import com.lhalj.spring.escape.application_context.ApplicationContextStore;
import com.lhalj.spring.escape.application_context.UseIntitiallizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(value = {"com.lhalj.spring.escape","com.lhalj.spring.outer"})
public class SpringEscapeApplication {



    public static void main(String[] args) {
        SpringApplication.run(SpringEscapeApplication.class, args);

        //第一种方式获取应用上下文
        //SpringApplication application = new SpringApplication(SpringEscapeApplication.class);
        //application.addInitializers(new UseIntitiallizer());
        //application.run(args);

        //第三种方式获取应用上下文
        //ApplicationContextStore.setApplicationContext(SpringApplication.run(SpringEscapeApplication.class, args));
    }

}
