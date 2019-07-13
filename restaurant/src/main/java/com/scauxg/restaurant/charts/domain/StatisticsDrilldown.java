/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/5/19 14:15
 * History:
 */
package com.scauxg.restaurant.charts.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 封装下钻数据
 *
 * @author Yue
 * @create 2019/5/19
 * @since 1.0.0
 */
@Getter
@Setter
public class StatisticsDrilldown extends StatisticsOrder {
    private String drilldown;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("name", getName())
                .append("y", getY())
                .append("drilldown", getDrilldown())
                .toString();
    }
}
