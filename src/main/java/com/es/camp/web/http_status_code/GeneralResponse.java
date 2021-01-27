package com.es.camp.web.http_status_code;


import lombok.Data;


// 通用响应对象
@Data
public class GeneralResponse<T> {

    private Integer code;
    private String message;

    private T data;

    public GeneralResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
