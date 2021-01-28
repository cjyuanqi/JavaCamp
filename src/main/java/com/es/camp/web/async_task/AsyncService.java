package com.es.camp.web.async_task;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class AsyncService {

    @Async
    public void asyncProcessO1() throws Exception {
        log.info("【开始执行异步任务1】-->{}:{}:thread-->{}","AsyncService","asyncProcessO1",Thread.currentThread().getName());
        Thread.sleep(2000);
        log.info("【结束执行异步任务1】-->{}:{}","AsyncService","asyncProcessO1");
    }

    @Async
    public Future<String> asyncProcessO2() throws Exception {
        log.info("【开始执行异步任务2】-->{}:{}:thread-->{}","AsyncService","asyncProcessO2",Thread.currentThread().getName());
        Thread.sleep(2000);
        log.info("【结束执行异步任务2】-->{}:{}","AsyncService","asyncProcessO2");
        return new AsyncResult<>("iCourse--jun.chen");
    }

    @Async
    public void asyncProcessO3() throws Exception {
        log.info("【开始执行异步任务3】-->{}:{}:thread-->{}","AsyncService","asyncProcessO3",Thread.currentThread().getName());
        Thread.sleep(2000);
        throw new RuntimeException("throw runtime exception in async process 03");
    }

}
