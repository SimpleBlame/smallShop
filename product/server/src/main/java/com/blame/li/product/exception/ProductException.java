package com.blame.li.product.exception;

import com.blame.li.product.enums.ResultEnum;

/**
 * Create by li
 * 2019/5/10 20:50
 */
public class ProductException extends RuntimeException {
    private Integer code;

    public ProductException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
