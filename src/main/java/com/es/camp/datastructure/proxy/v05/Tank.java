package com.es.camp.datastructure.proxy.v05;

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

    public static void main(String[] args) {
        new TankTimeProxy(new Tank()).move();
    }
}

class TankLogProxy implements Moveable {

    private Tank tank;

    public TankLogProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        System.out.println("start tank");
        tank.move();
        System.out.println("end tank");
    }
}

interface Moveable {
    void move();
}
