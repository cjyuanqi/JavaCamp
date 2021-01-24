package com.es.camp.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GEEKCourse {

    public void print() {
        log.info("「开始执行 {}」=========", "print方法");
    }
}
