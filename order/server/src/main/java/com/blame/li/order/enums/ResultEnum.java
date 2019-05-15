package com.blame.li.order.enums;

import lombok.Getter;

/**
 * Create by li
 * 2019/5/10 20:19
 */
@Getter
public enum  ResultEnum {
    PARAM_ERROR(1,"参数有误"),
    CART_EMPTY(2,"购物车为空"),
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
