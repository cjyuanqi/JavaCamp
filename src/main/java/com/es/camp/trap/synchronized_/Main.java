package com.es.camp.trap.synchronized_;

public class Main {

    public static void main(String[] args) {
//        Active active = new Active();

//        MainActive active = new MainActive();

        SubActive active = new SubActive();

        Thread thread1 = new Thread(active,"thread1");
        Thread thread2 = new Thread(active,"thread2");
        Thread thread3 = new Thread(active,"thread3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
