/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/4/5 0:07
 * History:
 */
package com.scauxg.restaurant.food.VO;

import com.scauxg.restaurant.food.domain.Menu;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 菜品数据展示包装类
 *
 * @author Yue
 * @create 2019/4/5
 * @since 1.0.0
 */
public class MenuVO extends Menu {
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("category", getCategory())
                .append("menuId", getMenuId())
                .append("menuName", getMenuName())
                .append("menuPrice", getMenuPrice())
                .append("menuRemark", getMenuRemark())
                .toString();
    }
}
