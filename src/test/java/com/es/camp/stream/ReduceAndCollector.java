package com.es.camp.stream;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
public class ReduceAndCollector {

    @Test
    public void reduceTest() {

        @Data
        @AllArgsConstructor
        class Order {
            /** 订单编号 */
            private Integer id;

            /** 商品数量 */
            private Integer productCount;

            /** 消费总金额 */
            private Double totalAmount;
        }

        // 准备数据
        ArrayList<Order> list = Lists.newArrayList();
        list.add(new Order(1, 2, 25.12));
        list.add(new Order(2, 5, 257.23));
        list.add(new Order(3, 3, 23332.12));

        /*
            汇总商品数量和总金额
         */
        Order order = list.stream()
                .parallel()
                .reduce(
                        // 初始化值
                        new Order(0,0,0.0),

                        // stream中两个元素计算逻辑
                        (o1,o2)->{
                            log.info("【执行计算逻辑】");
                    int productAmount = o1.getProductCount() + o2.getProductCount();
                    double totalAmount = o1.getTotalAmount() + o2.getTotalAmount();
                    return new Order(0, productAmount, totalAmount);
                },
                        // 并行操作下，多个结果合并逻辑
                        (o1,o2) -> {
                            log.info("【执行结果合并逻辑】");
                    int productAmount = o1.getProductCount() + o2.getProductCount();
                    double totalAmount = o1.getTotalAmount() + o2.getTotalAmount();
                    return new Order(0, productAmount, totalAmount);
                });

        log.info("==========【统计订单商品数量，消费金额】--> {}",JSON.toJSONString(order));
    }


    @Test
    public void collectTest() {
        /**
         * 订单对象
         */
        @Data
        @AllArgsConstructor
        class Order {
            /**
             * 订单编号
             */
            private Integer id;
            /**
             * 用户账号
             */
            private String account;
            /**
             * 商品数量
             */
            private Integer productCount;
            /**
             * 消费总金额
             */
            private Double totalAmount;
        }

        /*
            准备数据
         */
        ArrayList<Order> list = Lists.newArrayList();
        list.add(new Order(1, "zhangxiaoxi", 2, 25.12));
        list.add(new Order(2, "zhangxiaoxi",5, 257.23));
        list.add(new Order(3, "lisi",3, 23332.12));

        HashMap<String, Order> resultMap = list.stream()
                .parallel()
                .collect(
                        () -> {
                            log.info("【执行初始化容器】");
                            return new HashMap<String, Order>();
                        }, (HashMap<String, Order> map, Order newOrder) -> {
                            log.info("【执行运算】");
                            Order order = map.get(newOrder.getAccount());
                            if (order != null) {
                                order.setProductCount(order.getProductCount() + newOrder.getProductCount());
                                order.setTotalAmount(order.getTotalAmount() + newOrder.getTotalAmount());
                            } else {
                                map.put(newOrder.getAccount(), newOrder);
                            }
                        }, (HashMap<String, Order> map1, HashMap<String, Order> map2) -> {
                            log.info("【执行合并】");
                            map2.forEach((key, value) -> {
                                map1.merge(key, value, (order1, order2) -> {
                                    return new Order(0, key, order1.getProductCount() + order2.getProductCount(),
                                            order1.getTotalAmount() + order2.getTotalAmount());
                                });
                            });
                        });

        log.info("【执行结果】--> {}",resultMap);

    }
}
