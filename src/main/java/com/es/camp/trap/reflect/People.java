package com.es.camp.trap.reflect;

public class People {

    public String people(String hello) {
        return People.class.getName() + ":" + hello;
    }
}
