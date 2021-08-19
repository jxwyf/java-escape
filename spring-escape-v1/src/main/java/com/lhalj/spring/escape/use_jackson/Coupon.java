package com.lhalj.spring.escape.use_jackson;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 描述:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties({"couponCode","status"})
@JsonSerialize(using = CouponSerialize.class) //指定序列化方式、规则
public class Coupon {

    //@JsonIgnore //序列化直接忽略 不参与序列化
    private int id;

    //@JsonProperty("user")
    private Long userId;

    private String couponCode;

    //@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy/MM/dd hh:mm:ss")
    private Date assignTime;

    private CouponStatus status;

    private CouponTemplate template;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CouponTemplate{

        private String name;

        private String logo;

    }

    public static Coupon fake() {

        return new Coupon(
                1,100L,"123456",new Date(),
                CouponStatus.USABLE, new CouponTemplate("CouponTemplate","imooc")
        );
    }
}
