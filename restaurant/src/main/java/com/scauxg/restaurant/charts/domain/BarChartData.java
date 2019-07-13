/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/5/19 14:46
 * History:
 */
package com.scauxg.restaurant.charts.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 柱状图数据封装
 *
 * @author Yue
 * @create 2019/5/19
 * @since 1.0.0
 */
@Getter
@Setter
public class BarChartData<T,V> extends ChartData {
    private String id;
    private List<V> data;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("name", getId())
                .append("y", getData())
                .toString();
    }}
