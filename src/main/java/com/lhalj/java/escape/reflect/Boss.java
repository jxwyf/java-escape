package com.lhalj.java.escape.reflect;

/**
 * 描述:继承 Worker 的 Boss对象
 */
public class Boss extends Worker{

    public String boss(String hello){
        return Boss.class.getName() + ": " + hello;
    }

    public String numeric(int age){
        return Boss.class.getName() + ": " + age;
    }

}
