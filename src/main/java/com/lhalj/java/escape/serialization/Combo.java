package com.lhalj.java.escape.serialization;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 描述:类中存在引用对象
 */
@Getter
@Setter
public class Combo implements Serializable {

    private int id;
    private People people;

    public Combo(int id,People people){
        this.id = id;
        this.people = people;
    }
}
