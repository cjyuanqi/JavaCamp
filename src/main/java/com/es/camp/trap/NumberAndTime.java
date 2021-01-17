package com.es.camp.trap;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class NumberAndTime {

    private static void scaleProblem() {
        BigDecimal decimal = new BigDecimal("12.222");
        BigDecimal result = decimal.setScale(11);
        System.out.println(result);

        BigDecimal result2 = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(result2);
    }

    private static void devideProblem() {
//        System.out.println(new BigDecimal(30).divide(new BigDecimal(7)));
        System.out.println(new BigDecimal(30).divide(new BigDecimal(7),6,BigDecimal.ROUND_HALF_UP));
    }

    private static void equalProblem() {
        BigDecimal bd1 = new BigDecimal("0.00");
        BigDecimal db2 = new BigDecimal("0.0");
        System.out.println(bd1.equals(db2));
        System.out.println(bd1.compareTo(db2));
    }

    public static void main(String[] args) throws ParseException {
//        scaleProblem();
//        devideProblem();
//        equalProblem();

        formatPrecision();
    }

    public static void formatPrecision() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String time_str1 = "2020-11-21 09:11:12";
        String time_str2 = "2020-12";

        System.out.println(sdf.parse(time_str1));
        System.out.println(sdf.parse(time_str2));

    }

    private static void threadSafety() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    }
}
