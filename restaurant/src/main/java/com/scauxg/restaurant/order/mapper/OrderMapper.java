/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.order.mapper;

import com.scauxg.restaurant.order.VO.OrderVO;
import com.scauxg.restaurant.order.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 菜品 数据层
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Repository
public interface OrderMapper {
    /**
     * 查询信息
     *
     * @param orderId ID
     * @return 信息
     */
    public OrderVO selectOrderById(Integer orderId);

    /**
     * 查询列表
     *
     * @param order 信息
     * @return 集合
     */
    public List<OrderVO> selectOrderList(Order order);

    /**
     * 查询订单
     * @param order
     * @return
     */
    public List<OrderVO> selectPayOrderList(Order order);

    /**
     * 新增菜品
     *
     * @param order 信息
     * @return 结果
     */
    public int insertOrder(Order order);

    /**
     * 修改
     *
     * @param order 信息
     * @return 结果
     */
    public int updateOrder(Order order);


}