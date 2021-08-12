package com.lhalj.spring.escape.service;


import org.springframework.stereotype.Service;

/**
 * 描述:Spring Bean 的默认名称生成策略
 * 第一个字母大写 变小写 Spring -> spring
 * 如果开头两个字母都是大写 则返回原类名 SPring -> SPring
 */
@Service
public class SpringImooc {

    public void print(){
        System.out.println("SPringImooc");
    }

}
