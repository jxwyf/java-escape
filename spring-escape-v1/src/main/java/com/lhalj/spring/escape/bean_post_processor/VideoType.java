package com.lhalj.spring.escape.bean_post_processor;


public enum VideoType {

    AVI("AVI"),
    WMV("WMV");

    public String getDesc() {
        return desc;
    }

    VideoType(String desc) {
        this.desc = desc;
    }

    private String desc;


}
