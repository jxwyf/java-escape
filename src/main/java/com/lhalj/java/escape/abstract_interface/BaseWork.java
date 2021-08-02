package com.lhalj.java.escape.abstract_interface;

/**
 * 描述:没一个Worker最基本的属性
 */
public abstract class BaseWork {

    //起床时间
    protected int wakeupTime = 8;

    //上班打卡
    protected abstract void clockIn();

//    下班打卡
    protected abstract void clockOut();
}
