/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/5/14 22:55
 * History:
 */
package com.scauxg.restaurant.charts.service;

import com.scauxg.restaurant.charts.domain.ChartData;
import com.scauxg.restaurant.charts.domain.StatisticsDrilldown;
import com.scauxg.restaurant.charts.domain.StatisticsOrder;

/**
 * 销售订单统计 服务层
 *
 * @author Yue
 * @create 2019/5/14
 * @since 1.0.0
 */
public interface IStatisticsOrderService {
    /**
     * 统计每年各个月的销售总额
     * @param year
     * @return
     */
    public ChartData<StatisticsOrder> statisticOrderByYear(Integer year);

    /**
     * 统计近几天的销售额
     * @param day
     * @return
     */
    public ChartData<StatisticsOrder> statisticOrderByDay(Integer day);

    public ChartData<StatisticsOrder> statisticCategory(String startTime, String endTime);

    public ChartData<StatisticsOrder> statisticMenu(Integer categoryId, String categoryName, String startTime, String endTime);

    /**
     * 统计菜类销售额
     * @param startTime
     * @param endTime
     * @return
     */
    public ChartData<StatisticsDrilldown> statisticsBarCategory(String startTime, String endTime);
}
