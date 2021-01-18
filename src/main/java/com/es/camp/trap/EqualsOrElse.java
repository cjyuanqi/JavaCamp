package com.es.camp.trap;

import java.util.*;

@SuppressWarnings("all")
public class EqualsOrElse {

    public static class User implements Comparable {
        private String name;
        private Integer age;

        public User() {
        }

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return name.equals(user.name) &&
                    age.equals(user.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        // compare to 比较位置, 多做练习, 多做理解. 而不是简单记忆.
        @Override
        public int compareTo(Object o) {
            return this.age - ((User) o).age + this.name.compareTo(((User) o).name);
        }
    }

    private static void equalsAndHashcode() {
        User user1 = new User("qinyi",19);
        User user2 = new User("qinyi",19);

        System.out.println(user1.equals(user2));

        // hashset, hashmap 先去判断 hashcode的值, 是否相同, 相同才去判断equals method.
        Set<User> userSet = new HashSet<>();
        userSet.add(user1);
        userSet.add(user2);

        System.out.println(userSet.size());

        Map<User, Integer> userMap = new HashMap<>();
        userMap.put(user1,0);
        userMap.put(user2,0);

        System.out.println(userMap.size());

    }

    private static void compareToAndEquals() {

    }

    public static void main(String[] args) {
        equalsAndHashcode();
    }
}
