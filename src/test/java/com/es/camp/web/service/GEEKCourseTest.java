package com.es.camp.web.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class GEEKCourseTest {

    @Autowired
    private GEEKCourse geekCourse;

    @Test
    public void printTest() {
        geekCourse.print();
    }
}