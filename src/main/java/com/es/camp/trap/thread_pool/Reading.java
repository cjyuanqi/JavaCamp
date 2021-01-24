package com.es.camp.trap.thread_pool;

import lombok.Data;

@Data
public class Reading implements Runnable {
    private int count;
    private String name;

    public Reading(int count, String name) {
        this.count = count;
        this.name = name;
    }


    @Override
    public void run() {
        while (count > 0) {
            System.out.println(Thread.currentThread().getName() + " read " + name);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            --count;
        }
    }
}
