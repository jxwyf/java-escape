package com.lhalj.spring.escape.service;

import com.lhalj.spring.escape.util.ApplicationUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:测试Spring Bean 默认名称生成策略
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSpringImooc {

    @Test
    public void testDefaultBeanName(){
        QYImooc qYImooc = (QYImooc) ApplicationUtils.getBean("qyImooc");
        qYImooc.print();
    }
}
