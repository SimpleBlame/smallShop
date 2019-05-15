package com.blame.li.product.service;

import com.blame.li.product.dataobject.ProductInfo;
import com.blame.li.product.dto.CartDTO;

import java.util.List;

/**
 * Create by li
 * 2019/5/10 20:52
 */
public interface ProductService {
    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);

}
