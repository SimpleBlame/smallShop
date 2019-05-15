package com.blame.li.order.repository;

import com.blame.li.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create by li
 * 2019/5/10 20:14
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
}
