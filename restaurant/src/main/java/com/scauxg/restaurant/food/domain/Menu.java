/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.food.domain;

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
public class Menu {
    private static final long serialVersionUID = 1L;

    /**
     * 菜品id
     */
    private Integer menuId;
    /**
     * 菜品名称
     */
    private String menuName;
    /**
     * 菜品价格
     */
    private Double menuPrice;
    /**
     * 菜品类别
     */
    private Integer menuCategory;
    /**
     * 描述说明
     */
    private String menuRemark;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("menuId", getMenuId())
                .append("menuName", getMenuName())
                .append("menuPrice", getMenuPrice())
                .append("menuCategory", getMenuCategory())
                .append("menuRemark", getMenuRemark())
                .toString();
    }
}
