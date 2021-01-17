package com.es.camp.trap.tryWithResource;

public class AutoClose implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("======= close");
        throw new RuntimeException("exception in close()");
    }

    public void worker() throws Exception {
        System.out.println("======== worker()");
        throw new MyException("exception in worker()");
    }
}
