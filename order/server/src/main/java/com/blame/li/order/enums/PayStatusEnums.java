package com.blame.li.order.enums;

import lombok.Getter;

/**
 * Create by li
 * 2019/5/10 20:18
 */
@Getter
public enum PayStatusEnums {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;
    private Integer code;
    private String message;
    PayStatusEnums(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
