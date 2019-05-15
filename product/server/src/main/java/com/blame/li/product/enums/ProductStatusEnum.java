package com.blame.li.product.enums;

import lombok.Getter;

/**
 * Create by li
 * 2019/5/10 20:45
 */
@Getter
public enum ProductStatusEnum {
    UP(0, "在架"),
    DOWN(1, "下架"),
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
