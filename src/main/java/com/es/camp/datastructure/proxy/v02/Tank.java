package com.es.camp.datastructure.proxy.v02;

public class Tank implements Moveable {


    /**
     * 获取tank移动的时间, 最直接的是修改源码
     */
    @Override
    public void move() {
        long start = System.currentTimeMillis();

        System.out.println("Tank start move....");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}

interface Moveable {
    void move();
}
