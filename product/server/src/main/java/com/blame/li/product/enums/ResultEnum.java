package com.blame.li.product.enums;

import lombok.Getter;

/**
 * Create by li
 * 2019/5/10 20:46
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(1,"商品不存在"),
    PRODUCT_STOCK_ERROR(2,"库存错误"),
    ;
    private Integer code;
    private String message;
    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}

