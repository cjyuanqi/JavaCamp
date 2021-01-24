package com.es.camp.web.service;

import com.es.camp.web.default_singleton.DefaultCourseManagerService;
import com.es.camp.web.util.ApplicationUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDefaultSingleton {

    @Test
    public void testDefaultSingleton() {
        log.info("【开始测试】---> {}", "testDefaultSingleton");
        DefaultCourseManagerService service01 = ApplicationUtils.getBean(DefaultCourseManagerService.class);
        DefaultCourseManagerService service02 = ApplicationUtils.getBean(DefaultCourseManagerService.class);

        service01.addCourse("Think in Java");
        service01.addCourse("SpringBoot in Action");
        log.info("==========Service01 has courses: {}", service01.getCourses());

        service02.addCourse("Head First Design!");
        log.info("==========Service01 has courses: {}", service01.getCourses());

    }


    @Test
    public void testServiceUnique() {
        log.info("【开始测试】---> {}", "testDefaultSingleton");
        DefaultCourseManagerService service01 = ApplicationUtils.getBean(DefaultCourseManagerService.class);
        DefaultCourseManagerService service02 = ApplicationUtils.getBean(DefaultCourseManagerService.class);
        assert  service01.hashCode() != service02.hashCode();

    }
}
