package com.es.camp.web.service;


import com.es.camp.web.async_task.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestAsyncTask {

    @Autowired
    private AsyncService asyncService;

    @Test
    public void testAsyncProcess() throws Exception {
        asyncService.asyncProcessO1();
        Future<String> future = asyncService.asyncProcessO2();
        log.info("【测试异步处理】return --> {}: thread --> {}", future.get(), Thread.currentThread().getName());
    }

    @Test
    public void testAsyncProcess2() throws Exception {
        asyncService.asyncProcessO3();
        Thread.sleep(3000);
    }



}
