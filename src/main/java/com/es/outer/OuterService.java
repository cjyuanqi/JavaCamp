package com.es.outer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OuterService {

    public void print() {
        log.info("『开始执行 print 方法』==========");
    }

}
