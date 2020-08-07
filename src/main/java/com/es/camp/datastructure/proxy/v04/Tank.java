package com.es.camp.datastructure.proxy.v04;

public class Tank implements Moveable{

    @Override
    public void move() {
        System.out.println("Tank started moving...");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Tank tank = new Tank();
        TankTimeProxy proxy = new TankTimeProxy(tank);
        proxy.move();
    }
}

class TankTimeProxy implements Moveable {

    private Tank tank;

    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

interface Moveable {
    void move();
}