package com.scauxg.restaurant.order.service;

import com.scauxg.restaurant.order.domain.Payment;
import com.scauxg.restaurant.order.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements IPaymentService{

    @Autowired
    private PaymentMapper paymentMapper;

    /**
     * 查询支付信息
     *
     * @param payId 支付订单ID
     * @return 支付信息
     */
    @Override
    public Payment selectPaymentById(Integer payId){return paymentMapper.selectPaymentById(payId);}

    /**
     * 查询订单支付列表
     *
     * @param payment 支付信息
     * @return 菜品集合
     */
    @Override
    public List<Payment> selectPaymentList(Payment payment){return paymentMapper.selectPaymentList(payment);}

    /**
     * 新增支付订单消息
     *
     * @param payment 支付信息
     * @return 结果
     */
    @Override
    public int insertPayment(Payment payment){return paymentMapper.insertPayment(payment);}

    /**
     * 修改支付
     *
     * @param payment 支付信息
     * @return 结果
     */
    @Override
    public int updatePayment(Payment payment){return paymentMapper.updatePayment(payment);}

}
