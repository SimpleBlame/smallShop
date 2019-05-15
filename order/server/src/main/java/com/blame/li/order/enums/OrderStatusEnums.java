package com.blame.li.order.enums;

import lombok.Getter;

/**
 * Create by li
 * 2019/5/10 20:18
 */
@Getter
public enum OrderStatusEnums {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"取消"),
    ;

    private Integer code;
    private String message;
    OrderStatusEnums(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
