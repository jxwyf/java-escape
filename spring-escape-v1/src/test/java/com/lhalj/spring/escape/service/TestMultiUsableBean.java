package com.lhalj.spring.escape.service;

import com.lhalj.spring.escape.multi_usable_bean.ITemplateManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMultiUsableBean {

    @Autowired
    //@Qualifier("fyRedisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    public void testAutowire(){

        assert redisTemplate != null;
        //清空数据库的所有数据
        //redisTemplate.getConnectionFactory().getConnection().flushAll();

        redisTemplate.opsForValue().set("name","qinyi");

    }

    @Autowired
    @Qualifier("imoocTemplateManagerService")
    private ITemplateManagerService service;

    @Test
    public void testTemplateManagerService(){

    }

}
