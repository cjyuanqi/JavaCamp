package com.es.camp.datastructure.proxy.v08;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

public class Tank implements Moveable {

    /**
     * 模拟坦克移动了一段儿时间
     */
    @Override
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Tank tank = new Tank();

        Moveable m = (Moveable)Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Moveable.class},
                new TimeProxy(tank));

        m.move();
    }

}

class TimeProxy implements InvocationHandler {

    private Moveable moveable;

    public TimeProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    public void before() {
        System.out.println("method start...");
    }

    public void after() {
        System.out.println("method end...");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o = method.invoke(moveable, args);
        after();

        return o;
    }
}

interface Moveable {
    void move();
}
