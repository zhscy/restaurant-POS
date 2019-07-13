/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/4/22 22:57
 * History:
 */
package com.scauxg.restaurant.order;

import com.scauxg.restaurant.common.DateUtils;
import com.scauxg.restaurant.order.VO.OrderVO;
import com.scauxg.restaurant.order.domain.Order;
import com.scauxg.restaurant.order.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * 订单明细
 *
 * @author Yue
 * @create 2019/4/22
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SalesOrderTest {
    @Autowired
    OrderMapper orderMapper;

    @Test
    public void readTest() {
        OrderVO order = orderMapper.selectOrderById(1);
        order.setTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, order.getOrderTime()));
        System.out.println("select====" + order);
    }

    @Test
    public void createTest() {
        Order order = new Order();
        order.setOrderTime(new Date());
        order.setOrderTotalPrice(66.0);
        order.setTableId(3);
        orderMapper.insertOrder(order);
    }

    @Test
    public void readListTest() {
//        Order order = new Order();
//        order.setOrderTime(new Date());
//        order.setOrderTotalPrice(66.0);
//        order.setTableId(3);

        List<OrderVO> orders = this.orderMapper.selectPayOrderList(new Order());
        for (Order orderd : orders) {
            System.out.println(orderd);
        }
    }

    @Test
    public void getIdTest() {
        Order order = new Order();
//        Date date = DateUtils.parseDate("2019-05-07 21:22:13");
        order.setOrderTime(new Date());
        order.setOrderTotalPrice(996.0);
        order.setTableId(4);
        orderMapper.insertOrder(order);
        System.out.println("id============" + order.getOrderId());
//        List<Order> orders = this.orderMapper.selectPayOrderList(order);
//        for (Order or : orders) {
//            System.out.println("===" + or);
//        }
    }

}
