package com.lhalj.spring.escape.service;

import com.lhalj.spring.escape.util.ApplicationUtils;
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
}
