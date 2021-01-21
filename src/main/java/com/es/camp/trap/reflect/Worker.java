package com.es.camp.trap.reflect;

public class Worker extends People {

    public String worker(String hello) {
        return Worker.class.getName() + ":" + hello;
    }

}
