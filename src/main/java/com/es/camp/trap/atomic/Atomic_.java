package com.es.camp.trap.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Atomic_ {

    private static int  count = 0;
    private static AtomicInteger atomicCount = new AtomicInteger(0);


    private static void accumulator(int acc) throws Exception {
        CountDownLatch cdl = new CountDownLatch(2);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < acc; i++) {
                    count++;
                }
                cdl.countDown();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < acc; i++) {
                    count++;
                }
                cdl.countDown();
            }
        });

        thread1.start();
        thread2.start();
        cdl.await();
        System.out.println(count);
    }

    private static void atomicAccumulator(int acc) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < acc; i++) {
                    atomicCount.getAndIncrement();
                }
                countDownLatch.countDown();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < acc; i++) {
                    atomicCount.getAndIncrement();
                }
                countDownLatch.countDown();
            }
        });

        thread1.start();
        thread2.start();
        countDownLatch.await();
        System.out.println(atomicCount.get());
    }


    public static void main(String[] args) throws Exception {
//        accumulator(1000);
        atomicAccumulator(1000);
    }





}
