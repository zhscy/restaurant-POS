package com.scauxg.restaurant.order;

import com.scauxg.restaurant.order.domain.Payment;
import com.scauxg.restaurant.order.mapper.PaymentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PayCURTest {

    @Autowired
    PaymentMapper paymentMapper;

    @Test
    public void createPayment(){
        Payment payment = new Payment();
        payment.setPayTime(new Date());
        payment.setPayWay(0);
        payment.setPayActual(323.20);
        payment.setPayTotal(400.5);
        payment.setPayChange(400.5-323.2);
        paymentMapper.insertPayment(payment);

        System.out.println("id======" + payment.getPayId());
    }

    @Test
    public void updatePayment(){
        Payment payment = new Payment();
        payment.setPayId(1);
        payment.setPayWay(1);
        payment.setPayTime(new Date());
        payment.setPayTotal(500.2);
        payment.setPayActual(300.0);
        payment.setPayChange(500.2-300);
        paymentMapper.updatePayment(payment);
    }

    @Test
    public void readPayment(){
        List<Payment> payments = paymentMapper.selectPaymentList(new Payment());
        for (Payment pay : payments) {
            System.out.println(pay);
        }

    }
}
