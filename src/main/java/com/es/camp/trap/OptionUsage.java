package com.es.camp.trap;

import java.util.Optional;

@SuppressWarnings("all")
public class OptionUsage {

    public static class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void badUsageOptional() {
        Optional<User> optional = Optional.ofNullable(null);
        User user = optional.orElse(null);
        user = optional.isPresent() ? optional.get() : null;

    }

    private static void isUserEqualNull() {
        User user = null;
        if (user == null) {
            System.out.println("User is null");
        }else {
            System.out.println("User is not null");
        }

        Optional<User> optionalUser = Optional.empty();
        if (optionalUser.isPresent()) {
            System.out.println("User is not null");
        } else {
            System.out.println("User is null");
        }
    }

    private static User anoymos() {
        return new User();
    }

    public static void main(String[] args) {
        User user = null;

        Optional<User> optional = Optional.ofNullable(user);
        // 存在则返回, 不存在则返回默认值
        optional.orElse(new User());
        // 存在则返回, 不存在则调用函数生成.
        optional.orElseGet(() -> anoymos());
        // 存在则返回, 不存在则抛出异常
        optional.orElseThrow(RuntimeException::new);
        // 存在则做相应处理
        optional.ifPresent(u -> System.out.println(u.getName()));
        // 存在则返回, 不存在则返回默认值
        optional.map(u -> u.getName()).orElse("anoymos");
        // map 可以做级联操作
        optional.map(u -> u.getName()).map(name -> name.length()).orElse(0);

    }
}
