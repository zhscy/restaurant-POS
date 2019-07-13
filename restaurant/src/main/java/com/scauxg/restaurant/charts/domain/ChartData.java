/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/5/17 9:59
 * History:
 */
package com.scauxg.restaurant.charts.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 图表实体
 *
 * @author Yue
 * @create 2019/5/17
 * @since 1.0.0
 */
@Getter
@Setter
public class ChartData<T> {
    private String title;
    private String yText;
    private String[] categories;
    private String seriesName;
    private List<T> seriesData;
}
