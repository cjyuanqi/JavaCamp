package com.es.camp.effective_skill.stream;

import com.es.camp.effective_skill.lambda.cart.CartService;
import com.es.camp.effective_skill.lambda.cart.Sku;

import java.util.List;

public class StreamOperator {

        List<Sku> skuList;

        public void init() {
            skuList = CartService.getCartSkuList();
        }
}
