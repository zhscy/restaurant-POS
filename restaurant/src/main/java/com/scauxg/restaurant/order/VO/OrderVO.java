package com.scauxg.restaurant.order.VO;

import com.scauxg.restaurant.order.domain.Order;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
// import java.util.Date;

@Getter
@Setter
public class OrderVO extends Order{

    /**
     * 餐桌号
     */
    private String table;

    /**
     * 支付方式
     */
    private Integer payWay;

    /**
     * 格式化时间
     */
    private String time;

    /**
     * 支付时间
     */
    private Date payTime;
    private String showPayTime;

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
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("orderId", getOrderId())
                .append("orderTime", getOrderTime())
                .append("time", getTime())
                .append("orderTotalPrice", getOrderTotalPrice())
                .append("table", getTable())
                .append("payWay", getPayWay())
                .append("payTime",getShowPayTime())
                .append("payTotal",getPayTotal())
                .append("payActual",getPayActual())
                .append("payChange",getPayChange())
                .toString();
    }

}
