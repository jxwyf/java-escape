package com.lhalj.java.escape.threadpool;

import java.util.concurrent.ExecutorService;

/**
 * 描述:可监控的线程池
 */
public class Main {

    public static void main(String[] args) {
        ExecutorService service = ExecutorsUtil.newFixedThreadPool(
                10,"20210810"
        );
        Runnable runnable01 = new Reading(3,"java 编程思想");
        Runnable runnable02 = new Reading(2,"Spring 实战");
        Runnable runnable03 = new Reading(1,"SpringBoot 实战");
        Runnable runnable04 = new Reading(4,"Mysql 权威指南");
        Runnable runnable05 = new Reading(6,"SpringCloud 实战");

        service.execute(runnable05);
        service.execute(runnable04);
        service.execute(runnable03);
        service.execute(runnable02);
        service.execute(runnable01);

        service.shutdown();
    }

}
