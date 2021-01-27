package com.es.camp.web.more_config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@ToString
@Component
@ConfigurationProperties(prefix = "course.user")
public class UserProperties {

    private String name;
    private Integer age;

}
