/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/5/12 12:22
 * History:
 */
package com.scauxg.restaurant.charts.controller;

import com.scauxg.restaurant.charts.domain.ChartData;
import com.scauxg.restaurant.charts.domain.StatisticsDrilldown;
import com.scauxg.restaurant.charts.domain.StatisticsOrder;
import com.scauxg.restaurant.charts.service.IStatisticsOrderService;
import com.scauxg.restaurant.food.domain.Category;
import com.scauxg.restaurant.food.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 图形报表
 *
 * @author Yue
 * @create 2019/5/12
 * @since 1.0.0
 */
@Controller
@RequestMapping("/charts")
public class ChartsController {
    private String prefix = "charts";

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IStatisticsOrderService statisticsOrderService;

/*    @RequestMapping("/test")
    public String test(ModelMap modelMap) {
        Category category = new Category();
        category.setCtgId(null);
        category.setCtgName("--类型--");
        category.setCtgRemark(null);
        List<Category> categories = new ArrayList<Category>() {{
            add(category);
        }};

        List<Category> categoryList = this.categoryService.selectCategoryList(new Category());

        categories.addAll(categoryList);

        modelMap.put("categories", categories);
//        return prefix + "/charts";
        return prefix + "/testChart";
    }

    @PostMapping("/postData")
    @ResponseBody
    public ReturnResult postData(@RequestParam("categoryId") Integer categoryId, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        System.out.println("categoryId===" + categoryId + ",startDate===" + startDate + ",endDate===" + endDate);
        return ReturnResult.success();
    }*/

    @RequestMapping("/lineChart")
    public String lineChart() {
        return prefix + "/lineChart";
    }

    @PostMapping("/postYear")
    @ResponseBody
    public ChartData<StatisticsOrder> postYear(@RequestParam(value = "year", required = false) Integer year) {
        if (year == null) {
            Calendar cal = Calendar.getInstance();
            year = cal.get(Calendar.YEAR);
//            System.out.println("year----" + year);
        }

        return statisticsOrderService.statisticOrderByYear(year);
    }

    @PostMapping("/postDay")
    @ResponseBody
    public ChartData<StatisticsOrder> postDay(@RequestParam("day") Integer day) {
        return statisticsOrderService.statisticOrderByDay(day);

    }


    @RequestMapping("/pieChart")
    public String pieChart(ModelMap modelMap) {
        Category category = new Category();
        category.setCtgId(null);
        category.setCtgName("所有");
        category.setCtgRemark(null);
        List<Category> categories = new ArrayList<Category>() {{
            add(category);
        }};
        List<Category> categoryList = this.categoryService.selectCategoryList(new Category());
        categories.addAll(categoryList);

        modelMap.put("categories", categories);
        return prefix + "/pieChart";
    }

    @PostMapping("/postData")
    @ResponseBody
    public ChartData<StatisticsOrder> postData(@RequestParam("categoryId") Integer categoryId,@RequestParam("categoryName") String categoryName,
                                               @RequestParam("startTime") String startTime, @RequestParam("endTime") String endTime) {
//        System.out.println("categoryId===" + categoryId + ",categoryName===" + categoryName + ",startDate===" + startTime + ",endTime===" + endTime);

        if (categoryId == null) {
            return statisticsOrderService.statisticCategory(startTime, endTime);
        }
        return statisticsOrderService.statisticMenu(categoryId, categoryName, startTime, endTime);
    }

    @RequestMapping("/barChart")
    public String barChart() {
        return prefix + "/barChart";
    }

    @PostMapping("/postBarData")
    @ResponseBody
    public ChartData<StatisticsDrilldown> postBarData(@RequestParam(value = "startTime", required = false) String startTime, @RequestParam(value = "endTime", required = false) String endTime) {
//        System.out.println("bar startTime===" + startTime + ",bar endTime===" + endTime);
        return statisticsOrderService.statisticsBarCategory(startTime, endTime);
    }

}
