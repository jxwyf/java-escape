package com.lhalj.spring.escape.service;

import com.lhalj.spring.escape.util.ApplicationUtils;
import com.lhalj.spring.outer.Outer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestHowToUseAutowire {

    @Test
    public void firstTryTest(){
        assert ApplicationUtils.getApplicationContext().containsBean("qyImooc");
        HowToUseAutowire autowire = new HowToUseAutowire();
        autowire.print();
    }

    @Test
    public void secondTryTest(){
        assert ApplicationUtils.getApplicationContext().containsBean("qyImooc");
        HowToUseAutowire autowire = new HowToUseAutowire();
        autowire.print();
    }

    @Test
    public void thirdTryTest(){
        //断言
        assert ApplicationUtils.getApplicationContext().containsBean("qyImooc");
        //容器管理
        HowToUseAutowire autowire = ApplicationUtils.getBean(HowToUseAutowire.class);
        autowire.print();
    }

    @Test
    public void fourthTryTest(){
        //断言
        assert ApplicationUtils.getApplicationContext().containsBean("outer");
        //容器管理
        ((Outer)ApplicationUtils.getBean("outer")).print();

    }
}
