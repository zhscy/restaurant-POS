/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/5/14 21:54
 * History:
 */
package com.scauxg.restaurant.charts.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 销售统计实体
 *
 * @author Yue
 * @create 2019/5/14
 * @since 1.0.0
 */
@Getter
@Setter
public class StatisticsOrder {
    private String name;
    private double y;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("name", getName())
                .append("y", getY())
                .toString();
    }
}
