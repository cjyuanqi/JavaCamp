package com.es.camp.web.http_status_code;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "this is the second way to set http status")
public class BadRequestException extends RuntimeException {

}
