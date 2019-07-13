/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.order.controller;

import com.scauxg.restaurant.common.DateUtils;
import com.scauxg.restaurant.order.VO.OrderVO;
import com.scauxg.restaurant.order.domain.Order;
import com.scauxg.restaurant.order.service.IItemService;
import com.scauxg.restaurant.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
//import com.ruoyi.framework.aspectj.lang.annotation.Log;


/**
 * 菜品 信息操作处理
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    private String prefix = "order";

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IItemService itemService;

    @GetMapping()
    public String order() {
        return prefix + "/order";
    }

    /**
     * 查询用户列表
     */
    @RequestMapping("/list")
    public String list(Order order, ModelMap modelMap) {
        List<OrderVO> orders = orderService.selectOrderList(order);
        for (OrderVO orderVO : orders) {
            orderVO.setTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, orderVO.getOrderTime()));
            orderVO.setShowPayTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, orderVO.getPayTime()));
        }
        modelMap.put("orders", orders);
        return prefix + "/order";
    }


    /**
     * 新增
     */
//    @GetMapping("/add")
//    public String add() {
//        return prefix + "/add";
//    }

    /**
     * 新增保存
     */
//    @PostMapping("/add")
//    @ResponseBody
//    public ReturnResult addSave(@RequestBody Order order, @RequestBody List<Item> items ) {
//        Order insertOrder;
//        return getReturnResult(order, items, orderService, itemService);
//    }

    /**
     * 修改
     */
//    @GetMapping("/edit/{orderId}")
//    public String edit(@PathVariable("orderId") Integer orderId, ModelMap mmap) {
//        Order order = orderService.selectOrderById(orderId);
//        mmap.put("order", order);
//        return prefix + "/edit";
//    }

    /**
     * 修改保存
     */
//    @PostMapping("/edit")
//    @ResponseBody
//    public ReturnResult editSave(Order order) {
//        return orderService.updateOrder(order) > 0 ? ReturnResult.success() : ReturnResult.error();
//    }



}
