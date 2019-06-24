package com.blame.li.user.enums;

import lombok.Getter;

/**
 * Create by li
 * 2019/5/10 20:46
 */
@Getter
public enum ResultEnum {
    LOGIN_FAIL(1,"登陆失败"),
    ROLE_FAIL(2, "权限角色错误"),
    ;
    private Integer code;
    private String message;
    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}

