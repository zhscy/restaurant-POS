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
 * 菜品类别表 category
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Getter
@Setter
public class Category {
    private static final long serialVersionUID = 1L;

    /**
     * 类别id
     */
    private Integer ctgId;
    /**
     * 菜单类别
     */
    private String ctgName;
    /**
     * 备注
     */
    private String ctgRemark;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("ctgId", getCtgId())
                .append("ctgName", getCtgName())
                .append("ctgRemark", getCtgRemark())
                .toString();
    }
}
