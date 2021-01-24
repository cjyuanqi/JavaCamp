package com.es.camp.trap.copy_on_write;

import java.util.ArrayList;
import java.util.List;

public class TaskPoolProblem {

    private static final List<String> tasks = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 10; i++) {
            tasks.add("task=" + i);
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    tasks.add("task-x");
                }
            }
        });

        thread.setDaemon(true);
        thread.start();

        Thread.sleep(1000L);

        for (String task: tasks) {
            System.out.println(task);
        }
    }
}
