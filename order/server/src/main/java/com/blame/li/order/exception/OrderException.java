package com.blame.li.order.exception;

import com.blame.li.order.enums.ResultEnum;

/**
 * Create by li
 * 2019/5/10 20:19
 */
public class OrderException extends RuntimeException {
    private Integer code;

    public OrderException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
