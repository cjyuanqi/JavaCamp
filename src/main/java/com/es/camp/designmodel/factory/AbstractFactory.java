package com.es.camp.designmodel.factory;

/**
 * 抽象工厂模式, 用于生产产品族.
 * 工厂模式, 用于生产具体产品.
 */
public abstract class AbstractFactory {
    abstract Food createFood();
    abstract Vehicle createVehicle();
    abstract Weapon createWeapon();

}
