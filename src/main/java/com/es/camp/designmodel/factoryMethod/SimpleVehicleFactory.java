package com.es.camp.designmodel.factoryMethod;

/**
 * 简单工厂可扩展性比较差.
 */
public class SimpleVehicleFactory {

    public Car createCar() {
        return new Car();
    }

    public Broom creatBroom() {
        return new Broom();
    }
}
