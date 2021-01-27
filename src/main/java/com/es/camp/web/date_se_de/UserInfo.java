package com.es.camp.web.date_se_de;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private Long id;
    private String name;

    // 此注解对 get方法没问题， 对post方法有问题
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonDeserialize(using = DateJacksonConverter.class)
    private Date birthday;
}
