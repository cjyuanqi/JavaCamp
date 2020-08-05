package com.es.camp.designmodel.adapter.wz.baseInterface;

public class Adaptor implements ITarget {
    // 对象适配器基于组合实现,  适用于接口定义大部分不同的情况.
    private Adaptee adaptee;

    @Override
    public void f1() {
        adaptee.fa();
    }

    @Override
    public void f2() {
        // 可以重新实现f2();
    }

    @Override
    public void fc() {
        adaptee.fc();
    }
}
