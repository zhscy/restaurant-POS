package com.scauxg.restaurant.order.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

@Getter
@Setter
public class Payment {

    private static final long serialVersionUID = 1L;

    /**
     * 支付订单id
     */
    private Integer payId;
    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 订单支付方式
     */
    private Integer payWay;

    /**
     * 支付金额
     */
    private Double payTotal;

    /**
     * 实收
     */
    private Double payActual;

    /**
     * 找零
     */
    private Double payChange;

    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("payId",getPayId())
                .append("payTime",getPayTime())
                .append("payWay",getPayWay())
                .append("payTotal",getPayTotal())
                .append("payActual",getPayActual())
                .append("payChange",getPayChange())
                .toString();

    }

}
