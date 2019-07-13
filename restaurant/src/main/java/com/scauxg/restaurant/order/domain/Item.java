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

/**
 * 菜品表 menu
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Getter
@Setter
public class Item {

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 订单细项id
     */
    private Integer itemId;
    /**
     * 用户名称
     */
    private String itemHandle;

    /**
     * 菜品ID
     */
    private Integer itemMenuId;

    /**
     * 菜品数量
     */
    private Integer itemAmount;
    /**
     * 菜品价格
     */
    private Double unitPrice;

    /**
     * 总价
     */
    private Double totalPrice;

    /**
     * 菜品准备状态
     */
    private Integer itemState;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("itemId", getItemId())
                .append("orderId", getOrderId())
                .append("itemHandle", getItemHandle())
                .append("itemMenuId", getItemMenuId())
                .append("itemAmount", getItemAmount())
                .append("unitPrice", getUnitPrice())
                .append("totalPrice", getTotalPrice())
                .append("itemState", getItemState())
                .toString();
    }
}
