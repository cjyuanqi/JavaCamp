package com.es.camp.effective_skill.lambda;


import java.util.function.Consumer;

public class MethodReference {

    public void test01() {
        Consumer<String> consumer1 = (String number) -> Integer.parseInt(number);

        Consumer<String>  consumer2 = Integer::parseInt;
    }

    public void test02() {
        Consumer<String> consumer = str -> str.length();

        Consumer<String> consumer1 = String::length;
    }

    public void test3() {
        StringBuilder stringBuilder = new StringBuilder();

        Consumer<String> consumer = string -> stringBuilder.append(string);

        Consumer<String> consumer1 = stringBuilder::append;

    }
}
