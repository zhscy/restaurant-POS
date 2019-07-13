/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/5/14 22:59
 * History:
 */
package com.scauxg.restaurant.charts.service;

import com.scauxg.restaurant.charts.domain.ChartData;
import com.scauxg.restaurant.charts.domain.StatisticsDrilldown;
import com.scauxg.restaurant.charts.domain.StatisticsOrder;
import com.scauxg.restaurant.charts.mapper.StatisticsOrderMapper;
import com.scauxg.restaurant.common.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 销售订单统计 服务层实现
 *
 * @author Yue
 * @create 2019/5/14
 * @since 1.0.0
 */
@Service
public class StatisticsOrderServiceImpl implements IStatisticsOrderService {
    @Autowired
    private StatisticsOrderMapper statisticsOrderMapper;

    @Override
    public ChartData<StatisticsOrder> statisticOrderByYear(Integer year) {
        String[] categories = {"一月", "二月", "三月", "四月", "五月", "六月","七月", "八月", "九月", "十月", "十一月", "十二月"};
        String title = year + "年销售统计";
        String yText = "各月销售总额";
        String seriesName = "月销售额";
        List<StatisticsOrder> seriesData = statisticsOrderMapper.statisticOrderByYear(year);

        ChartData<StatisticsOrder> chartData = new ChartData<>();
        chartData.setTitle(title);
        chartData.setYText(yText);
        chartData.setCategories(categories);
        chartData.setSeriesName(seriesName);
        chartData.setSeriesData(seriesData);

        return chartData;
    }

    @Override
    public ChartData<StatisticsOrder> statisticOrderByDay(Integer day) {
        String title = "近" + day + "天的日销售额";
        String yText = "日销售额";
        String seriesName = "当日销售额";
        String[] categories = new String[day];
        List<StatisticsOrder> seriesData = statisticsOrderMapper.statisticOrderByDay(day);
        for (int i = 0; i < seriesData.size() ; i++) {
            categories[i] = seriesData.get(i).getName();
        }

        ChartData<StatisticsOrder> chartData = new ChartData<>();
        chartData.setTitle(title);
        chartData.setYText(yText);
        chartData.setCategories(categories);
        chartData.setSeriesName(seriesName);
        chartData.setSeriesData(seriesData);
        return chartData;
    }

    @Override
    public ChartData<StatisticsOrder> statisticCategory(String startTime, String endTime) {
        String title = startTime + "~" + endTime + "分类汇总";
        String seriesName = "各类占比";

        Date start = DateUtils.parseDate(startTime);
        Date end = DateUtils.parseDate(endTime);
        List<StatisticsOrder> seriesData = statisticsOrderMapper.statisticCategory(start, end);

        ChartData<StatisticsOrder> chartData = new ChartData<>();
        chartData.setTitle(title);
        chartData.setSeriesName(seriesName);
        chartData.setSeriesData(seriesData);

        return chartData;
    }

    @Override
    public ChartData<StatisticsOrder> statisticMenu(Integer categoryId,String categoryName, String startTime, String endTime) {
        String title = startTime + "到" + endTime + categoryName + "中各菜品所占比例";
        String seriesName = categoryName;

        Date start = DateUtils.parseDate(startTime);
        Date end = DateUtils.parseDate(endTime);
        List<StatisticsOrder> seriesData = statisticsOrderMapper.statisticsMenu(categoryId, start, end);

        ChartData<StatisticsOrder> chartData = new ChartData<>();
        chartData.setTitle(title);
        chartData.setSeriesName(seriesName);
        chartData.setSeriesData(seriesData);
        return chartData;
    }

    @Override
    public ChartData<StatisticsDrilldown> statisticsBarCategory(String startTime, String endTime) {
        String title;
        if ((startTime != null && !startTime.equals("")) && (endTime != null && !endTime.equals(""))) {
            title = startTime + "~" + endTime  + "各菜类销售额";
        } else if ((startTime == null || startTime.equals("")) && (endTime != null && !endTime.equals(""))) {
            title = "到" + endTime + "为止各菜类销售额";
        } else if ((startTime != null && !startTime.equals("")) && (endTime == null || endTime.equals(""))) {
            title = "从" + startTime + "到至今各菜类销售额";
        } else {
            title = "各菜类历史销售额";
        }
        String yText = "销售额";
        String seriesName = "菜品";
        Date start = DateUtils.parseDate(startTime);
        Date end = DateUtils.parseDate(endTime);
        List<StatisticsDrilldown> seriesData = statisticsOrderMapper.statisticsBarCategory(start, end);

        ChartData<StatisticsDrilldown> chartData = new ChartData<>();
        chartData.setTitle(title);
        chartData.setYText(yText);
        chartData.setSeriesName(seriesName);
        chartData.setSeriesData(seriesData);

        return chartData;
    }

}
