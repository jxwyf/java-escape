package com.lhalj.spring.escape.cyclic_dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:Spring 循环依赖
 * Spring 使用三级缓存策略解决循环依赖问题
 * 解决单例模式下循环依赖的三级缓存
 *
 * 一级缓存 用于存放完全初始化好的bean
 * private final Map<String,Object> singletonObjects = new ConcurrentHashMap</String,Object>(256)
 *
 * 二级缓存 存放原始的bean对象(尚未填充属性)用于解决循环依赖
 * private final Map<String,Object> earlySingletonObjects = new HashMap</String,Object>(16)
 *
 * 三级缓存 存放原始bean工厂对象 用于解决循环依赖
 * private final Map<String,Objectfactory<?>> earlySingletonObjects = new HashMap</String,Objectfactory<?>>(16)
 */
@Service
public class ImoocCourseService {

    //private final QinyiJavaService javaService;
    //
    //@Autowired
    //public ImoocCourseService(QinyiJavaService javaService){
    //    this.javaService = javaService;
    //}

    //Field
    //@Autowired
    private QinyiJavaService javaService;

    //set
    @Autowired
    public void setQinyiJavaService (QinyiJavaService javaService){
        this.javaService = javaService;
    }

    public void imoocCourse(){
        javaService.qinyiJava();
    }
}
