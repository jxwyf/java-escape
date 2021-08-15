package com.lhalj.spring.escape.bean_post_processor;

import javafx.fxml.Initializable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * 描述:
 */
@Service
@Slf4j
public class AVIDecoder implements IDecoder, Initializable {
    @Override
    public VideoType type() {
        return VideoType.AVI;
    }

    @Override
    public String decode(String data) {
        return this.type().getDesc() + ": " + data;
    }

    //容器初始化 之后就会回调这个方法
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        log.info("Init AVIDecoder In Initializable");
    }
}
