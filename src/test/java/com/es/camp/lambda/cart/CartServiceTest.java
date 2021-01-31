package com.es.camp.lambda.cart;


import com.alibaba.fastjson.JSON;
import com.es.camp.designmodel.factoryMethod.Car;
import com.es.camp.effective_skill.lambda.cart.CartService;
import com.es.camp.effective_skill.lambda.cart.Sku;
import com.es.camp.effective_skill.lambda.cart.SkuCategoryEnum;
import com.es.camp.effective_skill.lambda.cart.SkuPredicate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class CartServiceTest {

    @Test
    public void testFilterElectronicsSku() {
        List<Sku> skus = CartService.filterElectronicsSkus(CartService.getCartSkuList());
        System.out.println(JSON.toJSONString(skus, true));
    }


    @Test
    public void testilterSkusByCategory() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> skus = CartService.filterSkusByCategory(cartSkuList, SkuCategoryEnum.BOOKS);
        log.info("【返回结果为】--> {}", JSON.toJSONString(skus,true));
    }

    @Test
    public void testFilterSkus() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> skus = CartService.filterSkus(cartSkuList, null, 2000.0, false);
        System.out.println(JSON.toJSONString(skus,true));
    }

    @Test
    public void testFilterSku2() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        // 过滤出书籍类商品
        List<Sku> bookSkus = CartService.filterSkus(cartSkuList, new SkuPredicate() {
            @Override
            public boolean test(Sku sku) {
                return sku.getSkuCategory().equals(SkuCategoryEnum.BOOKS);
            }
        });

        log.info("【书籍类商品】--> {}",JSON.toJSONString(bookSkus,true));

        log.info("======================= split line ===========================");

        // 过滤出价格大于 2000 类的商品
        List<Sku> bigOrder = CartService.filterSkus(cartSkuList, sku -> sku.getTotalPrice() > 2000.0);

        log.info("【商品价格大于 2000】--> {}",JSON.toJSONString(bigOrder,true));
    }


}
