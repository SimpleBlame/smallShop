package com.blame.li.order;

import com.blame.li.order.dataobject.OrderDetail;
import com.blame.li.order.repository.OrderDetailRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServerApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testDetailSave(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123678");
        orderDetail.setOrderId("12345678");
        orderDetail.setProductIcon("http:xxx.com");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(0.01));
        orderDetail.setProductQuantity(2);
        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertTrue(result != null);
    }

}
