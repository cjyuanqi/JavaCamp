package com.es.camp.trap.lombok;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <h1>lombok 工具的使用以及需要避免的坑</h1>
 */
public class Main {

    private static void singleAlphabetHump() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Personal personal = new Personal();
        personal.setIPhone("8.1");

        System.out.println(mapper.writeValueAsString(personal));

    }

    private static void equalsAndHashCodeBug() {
        AppleComputer computer1 = new AppleComputer(1, "mac1", 12000L, "white");
        AppleComputer computer2 = new AppleComputer(2, "mac2", 12800L, "gray");

        System.out.println(computer1.equals(computer2));
    }

    public static void main(String[] args) throws Exception  {
//        singleAlphabetHump();
        equalsAndHashCodeBug();
    }

}
