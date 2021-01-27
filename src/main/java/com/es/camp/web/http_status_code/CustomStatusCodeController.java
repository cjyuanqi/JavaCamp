package com.es.camp.web.http_status_code;


import com.es.camp.web.transaction_lost.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom")
public class CustomStatusCodeController {

    // 第一种方式返回状态码
    @GetMapping("/first")
    public ResponseEntity<GeneralResponse<String>> first() {
        GeneralResponse<String> response = new GeneralResponse<String>(0, "");
        response.setData("fist");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/second")
    public GeneralResponse<String> second() {
        throw new BadRequestException();
    }

    @GetMapping("/third")
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "This is the third way to return http status")
    public void response404() {

    }


    @GetMapping("/forth")
    public GeneralResponse<String> forth() throws CustomException {
        throw new CustomException("some error");
    }




}
