package com.lhalj.spring.escape.cyclic_dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 */
@Service
public class QinyiJavaService {


    //private final ImoocCourseService courseService;
    //
    //@Autowired
    //public QinyiJavaService(ImoocCourseService courseService){
    //    this.courseService = courseService;
    //}
    //Field 注入
    @Autowired
    private ImoocCourseService courseService;

    public void qinyiJava(){
        System.out.println("QinyiJavaService");
    }
}
