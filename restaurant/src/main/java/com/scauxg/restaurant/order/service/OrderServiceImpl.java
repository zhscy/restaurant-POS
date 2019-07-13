/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.order.service;

import com.scauxg.restaurant.order.VO.OrderVO;
import com.scauxg.restaurant.order.mapper.OrderMapper;
import com.scauxg.restaurant.order.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户 服务层实现
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 查询信息
     *
     * @param orderId ID
     * @return 信息
     */
    @Override
    public OrderVO selectOrderById(Integer orderId) {
        return orderMapper.selectOrderById(orderId);
    }

    /**
     * 查询列表
     *
     * @param order 信息
     * @return 集合
     */
    @Override
    public List<OrderVO> selectOrderList(Order order) {
        return orderMapper.selectOrderList(order);
    }

    /**
     * 查询订单
     * @param order
     * @return
     */
    @Override
    public List<OrderVO> selectPayOrderList(Order order) {
        return orderMapper.selectPayOrderList(order);
    }

    /**
     * 新增用户
     *
     * @param order 信息
     * @return 结果
     */
    @Override
    public int insertOrder(Order order) {
        return orderMapper.insertOrder(order);
    }

    /**
     * 修改菜品
     *
     * @param order 信息
     * @return 结果
     */
    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateOrder(order);
    }


}
