package com.lhalj.java.escape.abstract_interface;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// 部分程序员的工作
public interface IExtraWorking {

    void extraCoding();

    void extraTesting();

    default void config(){
        System.out.println("BaseWorking For Config");
    }

    static void time(){
        System.out.println(LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
    }
}
