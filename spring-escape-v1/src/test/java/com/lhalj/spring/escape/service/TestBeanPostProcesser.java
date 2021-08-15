package com.lhalj.spring.escape.service;

import com.lhalj.spring.escape.bean_post_processor.*;
import com.lhalj.spring.escape.util.ApplicationUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

/**
 * 描述:
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestBeanPostProcesser {

    @Autowired
    private AVIDecoder aviDecoder;

    @Autowired
    private WMVDecoder wmvDecoder;


    @Test
    public void testEasyUseDecoder(){

        VideoType type = getRandomVideoType();

        switch (type){
            case AVI:
                log.info(aviDecoder.decode("video"));
                break;
            case WMV:
                log.info(wmvDecoder.decode("video"));
                break;
            default:
                log.info("error");
        }

    }


    @Autowired
    private DecoderManager decoderManager;

    @Test
    public void testUseDecoderManager(){

        log.info(decoderManager.decode(getRandomVideoType(),"video"));
    }

    /*
     * 获取随机的 VideoType
     */
    private VideoType getRandomVideoType(){

        return VideoType.values()[new Random().nextInt(VideoType.values().length)];
    }


    @Test
    public void testCheckBeanFactoryPostProcessor(){

        ThirdPartyClass class01 = ApplicationUtils.getBean(ThirdPartyClass.class);
        ThirdPartyClass class02 = ApplicationUtils.getBean(ThirdPartyClass.class);

        System.out.println(class01.hashCode() == class02.hashCode());

    }

}
