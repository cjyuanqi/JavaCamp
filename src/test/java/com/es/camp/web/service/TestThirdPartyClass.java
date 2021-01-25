package com.es.camp.web.service;

import com.es.camp.web.bean_post_processor.ThirdPartyClass;
import com.es.camp.web.util.ApplicationUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestThirdPartyClass {



    @Test
    public void testBeanFactoryPostProcessor() {
        ThirdPartyClass service01 = (ThirdPartyClass) ApplicationUtils.getBean("thirdPartyClass");
        ThirdPartyClass service02 = (ThirdPartyClass) ApplicationUtils.getBean("thirdPartyClass");

        System.out.println(service01.hashCode());
        System.out.println(service02.hashCode());

    }
}
