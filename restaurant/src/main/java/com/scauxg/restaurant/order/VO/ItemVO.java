package com.scauxg.restaurant.order.VO;

import com.scauxg.restaurant.order.domain.Item;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
@Setter
public class ItemVO extends Item{

    /**
     * 菜品名称
     */
    private String menu;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("orderId", getOrderId())
                .append("itemId", getItemId())
                .append("itemHandle", getItemHandle())
                .append("itemMenuId", getItemMenuId())
                .append("menu", getMenu())
                .append("unitPrice", getUnitPrice())
                .append("itemAmount", getItemAmount())
                .append("totalPrice", getTotalPrice())
                .append("itemState", getItemState())
                .toString();
    }

}
