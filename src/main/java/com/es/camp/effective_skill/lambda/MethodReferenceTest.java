package com.es.camp.effective_skill.lambda;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceTest {

    static class Sku {
        private String skuName;
        private Integer skuPrice;

        public Integer getSkuPrice() {
            return skuPrice;
        }

        public static int staticComparePrice(Sku sku1, Sku sku2) {
            return sku1.getSkuPrice() - sku2.getSkuPrice();
        }

        public int instanceComparePrice(Sku sku) {
            return this.getSkuPrice() - sku.getSkuPrice();
        }
    }

    class PriceComparator{
        public int instanceComparePrice(Sku sku1, Sku sku2) {
            return sku1.getSkuPrice() - sku2.getSkuPrice();
        }
    }


    public void test() {
        List<Sku> skuList = new ArrayList<>();

        skuList.sort((sku1,sku2) -> sku1.getSkuPrice() - sku2.getSkuPrice());

        skuList.sort(Sku::instanceComparePrice);

        skuList.sort((sku1,sku2) -> {
            return Sku.staticComparePrice(sku1, sku2);
        });

        PriceComparator priceComparator = new PriceComparator();
        skuList.sort(priceComparator::instanceComparePrice);
        skuList.sort((Sku sku1,Sku sku2) -> {
            return priceComparator.instanceComparePrice(sku1, sku2);
        });

        skuList.sort(Sku::instanceComparePrice);
        skuList.sort((sku1,sku2) -> {
            return sku1.instanceComparePrice(sku2);
        });


    }
}
