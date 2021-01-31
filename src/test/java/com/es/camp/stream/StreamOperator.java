package com.es.camp.stream;


import com.alibaba.fastjson.JSON;
import com.es.camp.effective_skill.lambda.cart.CartService;
import com.es.camp.effective_skill.lambda.cart.Sku;
import com.es.camp.effective_skill.lambda.cart.SkuCategoryEnum;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamOperator {

    List<Sku> skuList;

    @Before
    public void init() {
        skuList = CartService.getCartSkuList();
    }

    @Test
    public void filterTest() {
        skuList.stream()
                .filter(sku -> sku.getSkuCategory().equals(SkuCategoryEnum.BOOKS))
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    @Test
    public void mapTest() {
        skuList.stream()
                .map(sku -> sku.getSkuName())
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    @Test
    public void flatMapTest() {
        skuList.stream()
                .flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
                .forEach(System.out::println);
    }

    @Test
    public void peekTest() {
        skuList.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .forEach(sku -> System.out.println(JSON.toJSONString(sku)));
    }

    @Test
    public void sortTest() {
        skuList.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .forEach(sku -> System.out.println(JSON.toJSONString(sku)));
    }

    @Test
    public void distinctTest() {
        skuList.stream()
                .map(sku -> sku.getSkuCategory())
                .distinct()
                .forEach(sku -> System.out.println(JSON.toJSONString(sku)));
    }

    @Test
    public void skipTest() {
        skuList.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(3)
                .forEach(sku -> System.out.println(JSON.toJSONString(sku)));
    }

    @Test
    public void limitTest() {
        skuList.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(1*3)
                .limit(3)
                .forEach(sku -> System.out.println(JSON.toJSONString(sku)));
    }

    @Test
    public void allMatchTest() {
        boolean match = skuList.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .allMatch(sku -> sku.getTotalPrice() > 100);
        System.out.println(match);
    }

    @Test
    public void anyMatchTest() {
        boolean match = skuList.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .anyMatch(sku -> sku.getTotalPrice() > 100);
        System.out.println(match);
    }

    @Test
    public void noneMatchTest() {
        boolean match = skuList.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .noneMatch(sku -> sku.getTotalPrice() > 10_000);
        System.out.println(match);
    }

    @Test
    public void findFirstTest() {
        Optional<Sku> first = skuList.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .findFirst();
        System.out.println(JSON.toJSONString(first.get()));
    }

    @Test
    public void findAnyTest() {
        Optional<Sku> first = skuList.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .findAny();
        System.out.println(JSON.toJSONString(first.get()));
    }


    @Test
    public void maxTest() {
        Optional<Sku> max = skuList.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .max(Comparator.comparing(Sku::getTotalPrice));
        System.out.println(JSON.toJSONString(max.get()));
    }

    @Test
    public void minTest() {
        Optional<Sku> min = skuList.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .min(Comparator.comparing(Sku::getTotalPrice));
        System.out.println(JSON.toJSONString(min.get()));
    }

    @Test
    public void countTest() {
        long count = skuList.stream()
                .count();
        System.out.println(count);
    }







}
