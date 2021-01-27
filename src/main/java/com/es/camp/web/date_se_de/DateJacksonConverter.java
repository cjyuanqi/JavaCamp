package com.es.camp.web.date_se_de;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@Slf4j
public class DateJacksonConverter extends JsonDeserializer<Date> {

    private static final String[] parttern = new String[]{
            "yyyy-MM-dd HH:mm:ss","yyyy/MM/dd"
    };

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Date targetDate = null;

        String originDate = jsonParser.getText();
        if (StrUtil.isNotEmpty(originDate)) {
            try {
                long longDate = Long.parseLong(originDate.trim());
                targetDate = new Date(longDate);
            } catch (NumberFormatException e) {
                try {
                    targetDate = DateUtils.parseDate(originDate, DateJacksonConverter.parttern);
                } catch (ParseException parseException) {
                    log.info("parse date error:{}", parseException.getMessage());
                    parseException.printStackTrace();
                }
            }
        }

        return targetDate;
    }

    @Override
    public Class<?> handledType() {
        return Date.class;
    }
}
