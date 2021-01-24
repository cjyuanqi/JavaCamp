package com.es.camp.trap.synchronized_;

public class MainActive implements Runnable {

    private int value = 1000;

    @Override
    public synchronized void run() {
        String name = Thread.currentThread().getName();
        while (true) {
            if (value > 0) {
                System.out.println(name + " start value: " + value);
                value--;
                System.out.println(name + " end value: " + value);
            }else {
                break;
            }
        }
    }
}
