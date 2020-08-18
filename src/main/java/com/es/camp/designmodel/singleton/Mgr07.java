package com.es.camp.designmodel.singleton;

/**
 * 跟01是一个意思
 */
public class Mgr07 {
    private static final Mgr07 INSTANCE;
    static {
        INSTANCE = new Mgr07();
    }

    private Mgr07() {};

    public static Mgr07 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr07 m1 = Mgr07.getInstance();
        Mgr07 m2 = Mgr07.getInstance();
        System.out.println(m1 == m2);
    }
}

