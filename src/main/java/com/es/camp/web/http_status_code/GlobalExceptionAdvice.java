package com.es.camp.web.http_status_code;

import com.es.camp.web.transaction_lost.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

// 全局统一异常处理
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = CustomException.class )
    public ResponseEntity<GeneralResponse<String>> handleCustomException(HttpServletRequest request, CustomException e) {
        GeneralResponse<String> response = new GeneralResponse<>(0, "");
        response.setData(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
