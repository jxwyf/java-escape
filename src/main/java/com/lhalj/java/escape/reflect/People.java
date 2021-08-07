package com.lhalj.java.escape.reflect;

/**
 * 描述:People对象
 */
public class People {

    public String people(String hello){
        return People.class.getName() + ":" +hello;
    }
}
