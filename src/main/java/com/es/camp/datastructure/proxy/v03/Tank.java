package com.es.camp.datastructure.proxy.v03;

public class Tank implements Moveable{


    @Override
    public void move() {
        System.out.println("Tank start moving....");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 当不可修改源码时, 可以使用继承来获取坦克移动时间.
 */
class Tank2 extends Tank {

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }
}

interface Moveable {
    void move();
}
