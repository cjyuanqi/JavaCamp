package com.es.camp.web.use_jackson;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Coupon {

    @JsonIgnore
    private int id;

    @JsonProperty("uid")
    private Long userId;

    private String couponCode;

    @JsonFormat
    private Date assignTime;

    private CouponStatus status;

    private CouponTemplate template;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CouponTemplate {
        private String name;
        private String logo;
    }

    public static Coupon fake() {
        return new Coupon(1, 1011L, "200903386032", new Date(), CouponStatus.USABLE, new CouponTemplate("coupon template", "imooc"));
    }

}
