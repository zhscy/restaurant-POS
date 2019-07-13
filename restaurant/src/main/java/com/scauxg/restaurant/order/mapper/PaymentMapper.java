package com.scauxg.restaurant.order.mapper;

import com.scauxg.restaurant.order.domain.Payment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMapper {
    /**
     * 查询支付信息
     *
     * @param payId 支付订单ID
     * @return 支付信息
     */
    public Payment selectPaymentById(Integer payId);

    /**
     * 查询订单支付列表
     *
     * @param payment 支付信息
     * @return 菜品集合
     */
    public List<Payment> selectPaymentList(Payment payment);

    /**
     * 新增支付订单消息
     *
     * @param payment 支付信息
     * @return 结果
     */
    public int insertPayment(Payment payment);

    /**
     * 修改支付
     *
     * @param payment 支付信息
     * @return 结果
     */
    public int updatePayment(Payment payment);
}
