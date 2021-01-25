package com.es.camp.web.bean_post_processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class B004_extend extends B004 {

    @Override
    public void toDo() {
        log.info("========B004_extent --> toDo ");
    }
}
