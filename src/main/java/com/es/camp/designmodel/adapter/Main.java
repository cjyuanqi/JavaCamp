package com.es.camp.designmodel.adapter;

import java.io.*;

public class Main {

    /**
     * InputStreamReader就是适配器, 将FileInputStream 转变成BufferedReader.
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("/Users/chenjun/Work/prac/test2.txt");
            InputStreamReader is = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(is);
            String line = br.readLine();
            while (line != null && line != ""){
                System.out.println(line);
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
