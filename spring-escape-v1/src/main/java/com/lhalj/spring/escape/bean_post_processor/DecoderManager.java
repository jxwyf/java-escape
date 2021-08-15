package com.lhalj.spring.escape.bean_post_processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 利用 BeanPostProcessor 实现索引
 */
@Service
@Slf4j
public class DecoderManager implements BeanPostProcessor {

    private static final Map<VideoType,IDecoder> videoTypeIndex = new HashMap<>(VideoType.values().length);



    public String decode(VideoType type, String data){

        String result = null;

        switch (type){
            case AVI:
                result = videoTypeIndex.get(VideoType.AVI).decode(data);
            case WMV:
                result = videoTypeIndex.get(VideoType.WMV).decode(data);
            default:
                log.info("error");
        }

        return result;
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(!(bean instanceof IDecoder)){
            return bean;
        }

        IDecoder decoder = (IDecoder) bean;
        VideoType type = decoder.type();

        if(videoTypeIndex.containsKey(type)){
            throw new IllegalStateException("重复注册");
        }

        log.info("Load Decoder P{}for video type{}",decoder.getClass(),type.getDesc());

        videoTypeIndex.put(type, decoder);


        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(!(bean instanceof IDecoder)){
            return bean;
        }

        log.info("BeanPostProcessor after init: {}",bean.getClass());
        return null;
    }
}
