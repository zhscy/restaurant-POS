/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.order.domain;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 订单表 order
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Getter
@Setter
public class Order {
    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 订单时间
     */
    private Date orderTime;
    /**
     * 订单总价
     */
    private Double orderTotalPrice;
    /**
     * 桌号
     */
    private Integer tableId;
    /**
     * 订单支付状态
     */
    private Integer payState;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("orderId", getOrderId())
                .append("orderTime", getOrderTime())
                .append("orderTotalPrice", getOrderTotalPrice())
                .append("tableId", getTableId())
                .append("payState", getPayState())
                .toString();
    }
}
