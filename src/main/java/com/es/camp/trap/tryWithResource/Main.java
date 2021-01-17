package com.es.camp.trap.tryWithResource;

import java.io.*;

public class Main {

    public String newTryWithResource() {
        try ( FileInputStream in = new FileInputStream("");
              OutputStream out = new FileOutputStream("")) {

            byte[] buffer = new byte[100];
            int n = 0;
            while ((n = in.read(buffer)) != -1) {
                out.write(buffer,0,n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) throws Exception {
//        AutoClose autoClose = new AutoClose();

//        try {
//            autoClose.worker();
//        } finally {
//            autoClose.close();
//        }

        try(AutoClose autoClose = new AutoClose()) {
            autoClose.worker();
        }

    }
}
