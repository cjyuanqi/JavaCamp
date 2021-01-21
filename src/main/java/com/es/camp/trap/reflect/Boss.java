package com.es.camp.trap.reflect;

public class Boss extends Worker {

    public String boss(String hello) {
        return Boss.class.getName() + ":" + hello;
    }

    public String numeric(int age) {
        return Boss.class.getName() + ":" + age;
    }
}
