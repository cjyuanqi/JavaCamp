package com.es.camp.web.use_jackson;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CouponStatus {

    USABLE(1,"可用的"),
    USED(2,"使用过的");

    private Integer code;

    private String desc;


}
