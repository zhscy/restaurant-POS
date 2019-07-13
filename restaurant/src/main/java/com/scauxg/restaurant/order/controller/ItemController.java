/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.order.controller;

import com.scauxg.restaurant.common.ReturnResult;
import com.scauxg.restaurant.order.VO.ItemVO;
import com.scauxg.restaurant.order.domain.Item;
import com.scauxg.restaurant.order.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/item")
public class ItemController {
    private String prefix = "item";

    @Autowired
    private IItemService itemService;

    @GetMapping()
    public String item() {
        return prefix + "/item";
    }

    /**
     * 查询列表
     */
    @RequestMapping(value = {"/list/{orderId}", "/list"})
    public String list(Item item, ModelMap modelMap, @PathVariable(value = "orderId", required = false) Integer orderId) {
        item.setOrderId(orderId);
        List<ItemVO> items = itemService.selectItemList(item);
        modelMap.put("items", items);
        return prefix + "/item";
    }


    /**
     * 新增
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存
     */
    @PostMapping("/add")
    @ResponseBody
    public ReturnResult addSave(Item item) {
        return itemService.insertItem(item) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{itemId}")
    public String edit(@PathVariable("itemId") Integer itemId, ModelMap mmap) {
        Item item = itemService.selectItemById(itemId);
        mmap.put("item", item);
        return prefix + "/edit";
    }

    /**
     * 修改保存
     */
    @PostMapping("/edit")
    @ResponseBody
    public ReturnResult editSave(Item item) {
        return itemService.updateItem(item) > 0 ? ReturnResult.success() : ReturnResult.error();
    }


}
