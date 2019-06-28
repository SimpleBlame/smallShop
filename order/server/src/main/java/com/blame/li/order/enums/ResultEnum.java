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
    ORDER_NOT_EXIT(3, "订单不存在"),
    ORDER_STATUS_ERROR(4, "订单状态错误"),
    ORDER_DETAIL_EXIT(5, "订单详情不存在"),
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
