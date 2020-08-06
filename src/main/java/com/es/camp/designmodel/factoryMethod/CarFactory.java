package com.es.camp.designmodel.factoryMethod;

public class CarFactory {

    public Moveable create() {
        System.out.println("a car created");
        return new Car();
    }
}
