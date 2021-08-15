package com.lhalj.spring.outer;

import org.springframework.stereotype.Component;

/**
 * 描述:在默认扫描机制之外定义的 Bean
 */
@Component
public class Outer {
    public void print(){
        System.out.println("This is An Outer Class!");
    }
}
