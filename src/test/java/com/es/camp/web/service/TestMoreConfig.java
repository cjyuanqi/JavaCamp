package com.es.camp.web.service;

import com.es.camp.web.more_config.UserProperties;
import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMoreConfig {

    @Autowired
    private UserProperties userProperties;

    @Test
    public void testUserProperties() {
        assert userProperties != null;
        log.info("========= testUserProperties --> {}", userProperties.toString());
    }
}
