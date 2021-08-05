package com.lhalj.java.escape.serialization;

import lombok.ToString;

import java.io.Serializable;

/**
 * 描述:java object
 */
@ToString
public class Worker extends People implements Serializable {

    private String name;
    private Integer age;

    public Worker(Long id, String name, Integer age){
        super(id);
        this.age = age;
        this.name = name;
    }
}
