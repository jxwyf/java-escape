package com.lhalj.spring.escape.default_singleton;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.beans.BeanDescriptor;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 */
@Slf4j
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE) //原型模式
public class DefaultImoocerManagerService {

    private List<String> imoocers = null;

    //Bean 初始化
    @PostConstruct
    public void init(){
        log.info("Coming In DefaultImoocerManagerService init!");
        this.imoocers = new ArrayList<>(100);
    }


    public void addImoocer(String imoocer){
        this.imoocers.add(imoocer);
    }

    //获取容量
    public int imoocerCount(){
        return this.imoocers.size();
    }

    public List<String> getImoocers(){
        return this.imoocers;
    }

}
