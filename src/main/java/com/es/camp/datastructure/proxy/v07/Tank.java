package com.es.camp.datastructure.proxy.v07;


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

        Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Moveable.class},new LogHandler(tank));
    }


}


class LogHandler implements InvocationHandler {

    Tank tank;

    public LogHandler(Tank tank) {
        this.tank = tank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Method " + method.getName() + " start");
        Object o = method.invoke(tank, args);
        System.out.println("Method " + method.getName() + " end");
        return o;
    }
}


interface Moveable {
    void move();
}
