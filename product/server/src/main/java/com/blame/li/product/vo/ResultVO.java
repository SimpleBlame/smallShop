package com.blame.li.product.vo;

import lombok.Data;

/**
 * Create by li
 * 2019/5/10 20:47
 */
@Data
public class ResultVO<T> {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
