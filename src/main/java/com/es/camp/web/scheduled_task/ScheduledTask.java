package com.es.camp.web.scheduled_task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@SuppressWarnings("all")
public class ScheduledTask {

    @Scheduled(fixedDelay = 1000)
    public void taskOne() {
        log.info("========【任务1】 Scheduled task process01");
        while (true) {
            try {
                Thread.sleep(2000);
                log.info("======【任务1】handle some process");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void taskTwo() {
        log.info("=======【任务2】Scheduled task process02");
    }

}
