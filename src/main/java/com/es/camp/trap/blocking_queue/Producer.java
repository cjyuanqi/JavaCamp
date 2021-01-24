package com.es.camp.trap.blocking_queue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private static int element = 0;
    private final BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (element < 10) {
            try {
                System.out.println("Produce element:" + element);
                blockingQueue.put(element++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Produce Done!");
    }
}
