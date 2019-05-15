package com.blame.li.order.dto;

import com.blame.li.order.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Create by li
 * 2019/5/10 20:21
 */
@Data
public class OrderDTO {
    /** 订单ID */
    private String orderId;

    /** 买家名字 */
    private String buyerName;

    /** 买家手机号 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家微信ID */
    private String buyerOpenid;

    /** 订单金额 */
    private BigDecimal orderAmount;

    /** 订单状态,默认0新下单 */
    private Integer orderStatus;

    /** 支付状态,默认0未支付 */
    private Integer payStatus;

    private List<OrderDetail> orderDetailList;
}
