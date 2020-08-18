package com.es.camp.designmodel.singleton;

/**
 * 跟01是一个意思
 */
public class Mgr06 {
    private static final Mgr06 INSTANCE;
    static {
        INSTANCE = new Mgr06();
    }

    private Mgr06() {};

    public static Mgr06 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr06 m1 = Mgr06.getInstance();
        Mgr06 m2 = Mgr06.getInstance();
        System.out.println(m1 == m2);
    }
}

