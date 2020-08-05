package com.es.camp.designmodel.adapter.wz.baseClass;

/**
 * 类适配器, 基于继承实现, 适用于接口很多相同的情况下.
 */
public class Adaptor extends Adaptee implements ITarget{

    public void f1() {
        super.fa();
    }

    @Override
    public void f2() {
        // 重新实现f2();
    }

    // fc() 不需要实现, 可以直接继承Adaptee

}
