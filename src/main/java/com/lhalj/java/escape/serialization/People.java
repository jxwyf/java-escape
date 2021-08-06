package com.lhalj.java.escape.serialization;

import lombok.*;

import java.io.Serializable;
import java.time.Period;

/**
 * 描述:
 */
@Setter
@Getter
@ToString
public class People implements Serializable {

    private Long id;

    public People(){}


    public People(Long id){
        this.id = id;
    }
}
