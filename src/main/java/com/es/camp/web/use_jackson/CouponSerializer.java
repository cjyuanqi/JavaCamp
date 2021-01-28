package com.es.camp.web.use_jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class CouponSerializer extends JsonSerializer<Coupon> {


    @Override
    public void serialize(Coupon coupon, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeStartObject();

        jsonGenerator.writeStringField("id", String.valueOf(coupon.getId()));
        jsonGenerator.writeStringField("userId", coupon.getUserId().toString());
        jsonGenerator.writeStringField("couponCode", coupon.getCouponCode());
        jsonGenerator.writeStringField("assignTime",
                new SimpleDateFormat("HH:mm:ss").format(coupon.getAssignTime()));
        jsonGenerator.writeStringField("status", coupon.getStatus().getDesc());

        jsonGenerator.writeStringField("name", coupon.getTemplate().getName());
        jsonGenerator.writeStringField("logo", coupon.getTemplate().getLogo());

        jsonGenerator.writeEndObject();
    }
}
