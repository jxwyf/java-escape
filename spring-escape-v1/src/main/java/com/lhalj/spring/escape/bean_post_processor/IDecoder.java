package com.lhalj.spring.escape.bean_post_processor;

/*
 * 解码器接口定义
 */
public interface IDecoder {

    VideoType type();

    String decode(String data);

}
