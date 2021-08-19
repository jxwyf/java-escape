package com.lhalj.spring.escape.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lhalj.spring.escape.use_jackson.Coupon;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;

/**
 * 描述:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TestObjectMapper {

    @Autowired
    private ObjectMapper mapper;

    //{"user":100,"assignTime":"2021/08/19 02:42:51"}
    @Test
    public void testUseJacksonAnnotation() throws Exception {

        //Coupon coupon = Coupon.fake();
        //coupon.setTemplate(null);

        //log.info("ObjectMapper Se Coupon:{}",mapper.writeValueAsString(coupon));

        String jsonCoupon = "{\"id\":\"1\",\"userId\":\"100\",\"couponCode\":\"123456\",\"assignTime\":\"11:10:03\",\"status\":\"USABLE\"}";

        mapper.setDateFormat(new SimpleDateFormat("HH:mm:ss"));


        log.info("{}", mapper.readValue(jsonCoupon,Coupon.class).getId());

    }

    //{"id":"1","userId":"100","couponCode":"123456","assignTime":"11:10:03","status":"可用的","name":"CouponTemplate","logo":"imooc"}





}
