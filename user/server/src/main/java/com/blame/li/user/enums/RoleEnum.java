package com.blame.li.user.enums;

import lombok.Getter;

/**
 * Create by li
 * 2019/6/24 23:49
 */
@Getter
public enum RoleEnum {
    BUYER(1, "买家"),
    SELLER(2, "卖家"),
    ;

    private Integer code;

    private String message;

    RoleEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
