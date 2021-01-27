package com.es.camp.web.date_se_de;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// 用于演示时间日期 序列化 反序列化
@RestController
@RequestMapping("/need/date")
public class NeedDateController {

    @GetMapping("/param")
    public Map<String,Long> data(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date date) {
        Map<String, Long> result = new HashMap<>();
        result.put("timestamp", date.getTime());
        return result;
    }

    @PostMapping("/user")
    public Map<String,String> postData(UserInfo userInfo) {
        Map<String, String> result = new HashMap<>();
        result.put("id", userInfo.getId().toString());
        result.put("name", userInfo.getName());
        result.put("birthday", String.valueOf(userInfo.getBirthday().getTime()));
        return result;
    }



}
