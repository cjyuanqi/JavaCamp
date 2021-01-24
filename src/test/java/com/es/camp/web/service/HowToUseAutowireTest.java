package com.es.camp.web.service;

import com.es.camp.web.util.ApplicationUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class HowToUseAutowireTest {

    @Autowired
    private HowToUseAutowire howToUseAutowire;


//    @Test
//    public void firstTryTest() {
//        assert ApplicationUtils.getApplicationContext().containsBean("geekCourse");
//        HowToUseAutowire howToUseAutowire = new HowToUseAutowire();
//        howToUseAutowire.print();
//    }

    @Test
    public void testSecondTry() {
        log.info("【开始测试】---> {}","testSecondTry");
        howToUseAutowire.print();
    }

}