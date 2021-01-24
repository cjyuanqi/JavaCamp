package com.es.camp.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HowToUseAutowire {

    @Autowired
    private GEEKCourse geekCourse;

    public void print() {
        geekCourse.print();
    }

}
