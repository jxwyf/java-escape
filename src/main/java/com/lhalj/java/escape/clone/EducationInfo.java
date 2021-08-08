package com.lhalj.java.escape.clone;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述:教育信息
 */
@Data
@AllArgsConstructor
public class EducationInfo implements /*Cloneable*/ Serializable {

    private String school;

    private String time;

    //@Override
    //public Object clone() throws CloneNotSupportedException{
    //    return super.clone();
    //}
}
