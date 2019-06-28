package com.blame.li.order.service;

import com.blame.li.order.dto.OrderDTO;

/**
 * Create by li
 * 2019/5/10 20:25
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 完结订单（只能卖家操作）
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);
}
