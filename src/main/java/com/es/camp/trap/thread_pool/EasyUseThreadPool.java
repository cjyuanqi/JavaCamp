package com.es.camp.trap.thread_pool;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;

public class EasyUseThreadPool {

    private static void useFixedThreadPool(int threadCount) {
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        Runnable task1 = new Reading(3, "Think in Java");
        Runnable task2 = new Reading(2, "Spring in Action");
        Runnable task3 = new Reading(1, "SpringBoot in Action");
        Runnable task4 = new Reading(3, "Mysql 权威指南");
        Runnable task5 = new Reading(2, "SpringCloud 实战");

        executor.execute(task1);
        executor.execute(task2);
        executor.execute(task3);
        executor.execute(task4);
        executor.execute(task5);

        executor.shutdown();
    }

    // 自定义线程池1, 当线程池满, 且队列也满的时候, 会抛出异常
    private static void customThreadPool1() {
        ThreadPoolExecutor custom = new ThreadPoolExecutor(1,1,30, TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(2));

        for (int i = 0; i < 5; i++) {
            custom.execute(new Reading(3,"Think in Java"));
        }

        custom.shutdown();
    }

    // 自定义线程池2, 添加自定义拒绝策略
    private static void customThreadPool2() {
        ThreadPoolExecutor custom = new ThreadPoolExecutor(1, 1, 30, TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(2), new CustomRejectionHandler());

        for (int i = 0; i < 5; i++) {
            custom.execute(new Reading(3,"Think in Java"));
        }

        custom.shutdown();
    }

    // 自定义拒绝策略类
    private static class CustomRejectionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                // 队列的put 方式是阻塞方法(当队列满时, 会阻塞当前方法, 当队列有空间时插入任务)
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {
//        useFixedThreadPool(3);
//        customThreadPool1();
        customThreadPool2();
    }
}
