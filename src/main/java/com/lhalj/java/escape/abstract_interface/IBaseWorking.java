package com.lhalj.java.escape.abstract_interface;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/*
 *程序员的基本工作
 */
public interface IBaseWorking {

    void baseCoding();

    void baseTesting();

    default void config(){
        System.out.println("BaseWorking For Config");
    }

    static void time(){
        System.out.println(LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
    }
}
