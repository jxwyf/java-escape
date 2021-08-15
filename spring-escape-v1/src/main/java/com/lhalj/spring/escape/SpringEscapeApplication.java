package com.lhalj.spring.escape;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(value = {"com.lhalj.spring.escape","com.lhalj.spring.outer"})
public class SpringEscapeApplication {



    public static void main(String[] args) {
        SpringApplication.run(SpringEscapeApplication.class, args);
    }

}
