/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.order.controller;

import com.scauxg.restaurant.common.ReturnResult;
import com.scauxg.restaurant.food.VO.MenuVO;
import com.scauxg.restaurant.food.domain.Menu;
import com.scauxg.restaurant.food.service.IMenuService;
import com.scauxg.restaurant.order.VO.ItemVO;
import com.scauxg.restaurant.order.domain.Item;
import com.scauxg.restaurant.order.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
//import com.ruoyi.framework.aspectj.lang.annotation.Log;


/**
 * 飞单分拣
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Controller
@RequestMapping("/sheet")
public class SheetController {
    private String prefix = "sheet";

    @Autowired
    private IItemService itemService;

    @Autowired
    private IMenuService menuService;

    @GetMapping()
    public String item() {
        return prefix + "/sheet";
    }

    /**
     * 准备列表
     */
    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
        // 类别数据
        MenuVO menu = new MenuVO();
        menu.setMenuId(null);
        menu.setMenuName("------");
        List<MenuVO> menus = new ArrayList<MenuVO>() {{
            add(menu);
        }};
        List<MenuVO> menuList = this.menuService.selectMenuList(new Menu());
        menus.addAll(menuList);
        modelMap.put("menus", menus);

        // 表格数据
        Item item = new Item();
        item.setItemState(0);
        List<ItemVO> items = itemService.selectItemList(item);
        modelMap.put("items", items);

        return prefix + "/sheet";
    }

    /**
     * 上菜列表
     */
    @RequestMapping("/ready")
    public String ready(ModelMap modelMap) {
        // 类别数据
        MenuVO menu = new MenuVO();
        menu.setMenuId(null);
        menu.setMenuName("------");
        List<MenuVO> menus = new ArrayList<MenuVO>() {{
            add(menu);
        }};
        List<MenuVO> menuList = this.menuService.selectMenuList(new Menu());
        menus.addAll(menuList);
        modelMap.put("menus", menus);

        // 表格数据
        Item item = new Item();
        item.setItemState(1);
        List<ItemVO> items = itemService.selectItemList(item);
        modelMap.put("items", items);

        return prefix + "/ready";
    }

    /**
     * 分拣分类
     * @param menuId
     * @param state
     * @param modelMap
     * @return
     */
    @RequestMapping("/postMenu")
    public String postMenu(@RequestParam("menuId") Integer menuId, @RequestParam("state") Integer state, ModelMap modelMap) {
        Item item = new Item();
        item.setItemMenuId(menuId);
        item.setItemState(state);
//        System.out.println("state==" + state);
        List<ItemVO> items = itemService.selectItemList(item);

        modelMap.put("items", items);

        return "sheet/sheet :: sheet_data";
    }


    /**
     * 状态修改
     * @param itemId
     * @param state
     * @return
     */
    @PostMapping("/edit")
    @ResponseBody
    public ReturnResult editSave(@RequestParam("itemId") Integer itemId, @RequestParam("state") Integer state) {
//        System.out.println("itemId" + itemId);
//        System.out.println("state" + state);

        Item item = new Item();
        item.setItemId(itemId);
        item.setItemState(state);

        return itemService.updateItem(item) > 0 ? ReturnResult.success() : ReturnResult.error();
    }


}
