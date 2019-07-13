/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/5/14 21:58
 * History:
 */
package com.scauxg.restaurant.charts.mapper;

import com.scauxg.restaurant.charts.domain.StatisticsDrilldown;
import com.scauxg.restaurant.charts.domain.StatisticsOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 订单统计 数据层
 *
 * @author Yue
 * @create 2019/5/14
 * @since 1.0.0
 */
@Repository
public interface StatisticsOrderMapper {
    /**
     * 统计每年各个月的销售总额
     * @param year
     * @return
     */
    public List<StatisticsOrder> statisticOrderByYear(Integer year);

    /**
     * 统计近几天的销售额
     * @param day
     * @return
     */
    public List<StatisticsOrder> statisticOrderByDay(Integer day);

    /**
     * 统计所有类别占比
     * @param startTime
     * @param endTime
     * @return
     */
    public List<StatisticsOrder> statisticCategory(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /**
     * 统计菜品占所在类的比例
     * @param categoryId
     * @param startTime
     * @param endTime
     * @return
     */
    public List<StatisticsOrder> statisticsMenu(@Param("categoryId") Integer categoryId, @Param("startTime") Date startTime, @Param("endTime") Date endTime);


    /**
     * 统计菜类销售额
     * @param startTime
     * @param endTime
     * @return
     */
    public List<StatisticsDrilldown> statisticsBarCategory(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    public List<StatisticsDrilldown> statisticsBarMenu();

}
