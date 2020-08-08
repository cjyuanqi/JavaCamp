package com.es.camp.datastructure.proxy.v06;


/**
 * 实现代理的组合使用
 */
public class Tank implements Moveable {


    @Override
    public void move() {
        System.out.println("Tank moving...");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        TankTimeProxy timeProxy = new TankTimeProxy(tank);
        TankLogProxy logProxy = new TankLogProxy(timeProxy);
        logProxy.move();
    }
}

class TankTimeProxy implements Moveable {

    private Moveable moveable;

    public TankTimeProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        moveable.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class TankLogProxy implements Moveable {

    private Moveable moveable;

    public TankLogProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        System.out.println("tank start");
        moveable.move();
        System.out.println("tank end");
    }
}



interface Moveable {
    void move();
}


