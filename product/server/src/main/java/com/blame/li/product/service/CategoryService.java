package com.blame.li.product.service;

import com.blame.li.product.dataobject.ProductCategory;

import java.util.List;

/**
 * Create by li
 * 2019/5/10 20:51
 */
public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
