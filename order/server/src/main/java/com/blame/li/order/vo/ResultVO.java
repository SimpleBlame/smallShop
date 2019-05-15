package com.blame.li.order.vo;

import lombok.Data;

/**
 * Create by li
 * 2019/5/10 20:17
 */
@Data
public class ResultVO<T> {
    private Integer code;

    private String msg;

    private T data;

}
