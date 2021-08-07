package com.lhalj.java.escape.reflect;

/**
 * 描述:基础People的Worker对象
 */
public class Worker extends People{
    public String worker(String hello){
        return Worker.class.getName() + ": " + hello;
    }
}
