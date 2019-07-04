package com.blame.li.product.client;

import com.blame.li.product.common.DecreaseStockInput;
import com.blame.li.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Create by li
 * 2019/5/10 20:30
 */
@FeignClient(name = "product",fallback = ProductClient.ProductClientFallBack.class)
//@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();


    @PostMapping("/product/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> cartDTOList);

    @Component
    public static class ProductClientFallBack implements ProductClient{

        public ProductClientFallBack(){

        }

        @Override
        public String productMsg() {
            return null;
        }

        @Override
        public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
            return null;
        }

        @Override
        public void decreaseStock(List<DecreaseStockInput> cartDTOList) {

        }
    }
}
