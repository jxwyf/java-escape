package com.lhalj.spring.escape.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 描述: 学会@Autowired注解
 */
public class HowToUseAutowire {

    @Autowired
    private QYImooc imooc;

    public void print(){
        imooc.print();
    }
}
