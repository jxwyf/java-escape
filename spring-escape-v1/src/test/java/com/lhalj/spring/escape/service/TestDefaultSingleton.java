package com.lhalj.spring.escape.service;

import com.lhalj.spring.escape.default_singleton.DefaultImoocerManagerService;
import com.lhalj.spring.escape.util.ApplicationUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDefaultSingleton {

    @Test
    public void testDefaultSingleton(){
        //assert ApplicationUtils.getApplicationContext().containsBean("defaultImoocerManagerService");
        DefaultImoocerManagerService service01 = (DefaultImoocerManagerService) ApplicationUtils.getBean("defaultImoocerManagerService");
        DefaultImoocerManagerService service02 = ApplicationUtils.getBean(DefaultImoocerManagerService.class);
        //
        service01.addImoocer("ku01");
        service01.addImoocer("ku02");
        log.info("Service01 Has Imoocers:{}",service01.getImoocers());
        //
        service02.addImoocer("ku03");
        service02.addImoocer("ku04");
        log.info("Service01 Has Imoocers:{}",service01.getImoocers());

    }

    @Test
    public void testDefaultSingleton_() {

        DefaultImoocerManagerService service01 = (DefaultImoocerManagerService) ApplicationUtils.getBean("defaultImoocerManagerService");
        DefaultImoocerManagerService service02 = ApplicationUtils.getBean(DefaultImoocerManagerService.class);

        assert service01.hashCode() == service01.hashCode();

    }
}
