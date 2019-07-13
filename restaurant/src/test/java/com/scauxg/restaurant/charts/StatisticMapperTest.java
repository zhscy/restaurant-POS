/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/5/14 22:15
 * History:
 */
package com.scauxg.restaurant.charts;

import com.scauxg.restaurant.charts.domain.StatisticsDrilldown;
import com.scauxg.restaurant.charts.domain.StatisticsOrder;
import com.scauxg.restaurant.charts.mapper.StatisticsOrderMapper;
import com.scauxg.restaurant.common.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * 订单统计测试
 *
 * @author Yue
 * @create 2019/5/14
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StatisticMapperTest {

    @Autowired
    StatisticsOrderMapper statisticsOrderMapper;

    @Test
    public void readListTest() {
        List<StatisticsOrder> statisticsOrders = statisticsOrderMapper.statisticOrderByYear(2019);
        for (StatisticsOrder statisticsOrder : statisticsOrders) {
            System.out.println("result===" + statisticsOrder);
        }
    }

    @Test
    public void readDayList() {
        List<StatisticsOrder> statisticsOrders = statisticsOrderMapper.statisticOrderByDay(7);
//        for (StatisticsOrder statisticsOrder : statisticsOrders) {
//            System.out.println("result===" + statisticsOrder);
//        }
        System.out.println("size=========" + statisticsOrders.size());
    }

    @Test
    public void readCategoryList() {
        Date startTime = DateUtils.parseDate("2019-05-07");
        Date endTime = DateUtils.parseDate("2019-05-13");
        System.out.println("startTime===" + startTime + ",endTime==" + endTime);

        List<StatisticsOrder> statisticsOrders = statisticsOrderMapper.statisticCategory(startTime, endTime);
        for (StatisticsOrder statisticsOrder : statisticsOrders) {
            System.out.println(statisticsOrder);
        }

    }

    @Test
    public void readMenuList() {
        Date startTime = DateUtils.parseDate("2019-05-07");
        Date endTime = DateUtils.parseDate("2019-05-13");
        System.out.println("startTime===" + startTime + ",endTime==" + endTime);

        List<StatisticsOrder> statisticsOrders = statisticsOrderMapper.statisticsMenu(7,startTime, endTime);
        for (StatisticsOrder statisticsOrder : statisticsOrders) {
            System.out.println(statisticsOrder);
        }
    }


    @Test
    public void readBarCategoryList() {
        Date startTime = DateUtils.parseDate("2019-05-07");
        Date endTime = DateUtils.parseDate("2019-05-13");
        System.out.println("startTime===" + startTime + ",endTime==" + endTime);

        List<StatisticsDrilldown> statisticsDrilldowns = statisticsOrderMapper.statisticsBarCategory(startTime, endTime);
        for (StatisticsDrilldown statisticsDrilldown : statisticsDrilldowns) {
            System.out.println(statisticsDrilldown);
        }
    }

    @Test
    public void readBarMenuList() {
//        Date startTime = DateUtils.parseDate("2019-05-07");
//        Date endTime = DateUtils.parseDate("2019-05-13");
//        System.out.println("startTime===" + startTime + ",endTime==" + endTime);

        List<StatisticsDrilldown> statisticsDrilldowns = statisticsOrderMapper.statisticsBarMenu();
        for (StatisticsDrilldown statisticsDrilldown : statisticsDrilldowns) {
            System.out.println(statisticsDrilldown);
        }
    }
}
