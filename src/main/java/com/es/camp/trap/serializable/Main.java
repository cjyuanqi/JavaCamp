package com.es.camp.trap.serializable;

import java.io.*;

public class Main {

    private static void testSerializablePeople() throws IOException, ClassNotFoundException {
        File file = new File("/Users/chenjun/Work/doc/people_10.java_");
        People people = new People(10L);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(people);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        People people1 = (People) ois.readObject();
        System.out.println(people1);
    }

    private static void testSerializableWorker() throws IOException, ClassNotFoundException {
        File file = new File("/Users/chenjun/Work/doc/worker_10.java_");
        Worker worker = new Worker(10L, "张菲", 19);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(worker);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Worker worker1 = (Worker) ois.readObject();
        System.out.println(worker1);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        testSerializablePeople();
        testSerializableWorker();
    }
}
