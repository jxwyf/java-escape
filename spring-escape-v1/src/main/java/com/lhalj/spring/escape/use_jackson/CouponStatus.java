package com.lhalj.spring.escape.use_jackson;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 描述:
 */
@Getter
@AllArgsConstructor
public enum CouponStatus {

    USABLE("可用的",1),
    USED("使用过的",2);

    private String desc;
    private Integer code;
}
