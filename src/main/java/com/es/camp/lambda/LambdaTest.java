package com.es.camp.lambda;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Description: TODO
 * Author: JunChen
 * Date: 2020/11/14 10:16 上午
 * Version: v1.0
 */
public class LambdaTest {


    public static void main(String[] args) {
//        Runnable r = () -> {
//            System.out.println("hello Lambda!");
//        };
//
//        new Thread(r).start();
//        Object o = () -> {
//            System.out.println("hello, this is OK?");
//        }

//        MyRunnable mr = () -> {
//            System.out.println("hello test");
//        };
//
//        Function<Integer, String> f = (Integer num) -> {
//            return Integer.toString(num);
//        };

//        Thread goToSchool = new Thread(()->{
//            System.out.println("this is from an anonymous method (lambda exp)");
//        });
//
//        goToSchool.start();

//        List<UserPO> userPOList = new ArrayList<>();
//        userPOList.add(new UserPO(1,"Lily","ShangHai"));
//        userPOList.add(new UserPO(2,"Jack","Beijing"));
//        userPOList.add(new UserPO(3,"XiaoMing","GuangZhou"));
//
//        userPOList.stream().map(e -> {
//            return new UserDTO(e.id, e.name, e.addr);
//        }).collect(Collectors.toList());

        primaryOccurrency("2","3","4","5","8","2");


    }

    // target type
    @FunctionalInterface
    interface MyRunnable {
        void run();
    }

    static class UserPO {
        int id;
        String name;
        String addr;

        public UserPO(int id, String name, String addr) {
            this.id = id;
            this.name = name;
            this.addr = addr;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        @Override
        public String toString() {
            return "UserPO{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", addr='" + addr + '\'' +
                    '}';
        }
    }


    public static void primaryOccurrency(String...numbers) {
        List<String> list = Arrays.asList(numbers);
        Map<Integer, IntSummaryStatistics> statisticsMap = list.stream()
                .map(e -> new Integer(e))
                .filter(e -> e % 2 == 0)
                .collect(Collectors.groupingBy(p -> p, Collectors.summarizingInt(p -> 1)));
        System.out.println("result is " + statisticsMap);
    }

  static  class UserDTO {
        int id;
        String username;
        String address;

        public UserDTO(int id, String username, String address) {
            this.id = id;
            this.username = username;
            this.address = address;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

      @Override
      public String toString() {
          return "UserDTO{" +
                  "id=" + id +
                  ", username='" + username + '\'' +
                  ", address='" + address + '\'' +
                  '}';
      }
  }


}
