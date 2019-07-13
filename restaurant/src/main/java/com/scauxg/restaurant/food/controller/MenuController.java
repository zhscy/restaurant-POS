/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.food.controller;

import com.scauxg.restaurant.common.ReturnResult;
import com.scauxg.restaurant.food.VO.MenuVO;
import com.scauxg.restaurant.food.domain.Category;
import com.scauxg.restaurant.food.domain.Menu;
import com.scauxg.restaurant.food.service.ICategoryService;
import com.scauxg.restaurant.food.service.IMenuService;
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
@RequestMapping("/menu")
public class MenuController {
    private String prefix = "menu";

    @Autowired
    private IMenuService menuService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    public String menu() {
        return prefix + "/menu";
    }

    /**
     * 查询菜品列表
     */
    @RequestMapping("/list")
    public String list(Menu menu, ModelMap modelMap) {
        List<MenuVO> menus = menuService.selectMenuList(menu);
        modelMap.put("menus", menus);
        return prefix + "/menu";
    }


    /**
     * 新增菜品
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        List<Category> categories = this.categoryService.selectCategoryList(new Category());
        modelMap.put("categories", categories);
        return prefix + "/add";
    }

    /**
     * 新增保存菜品
     */
//	@Log(title = "菜品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public ReturnResult addSave(Menu menu) {
        return menuService.insertMenu(menu) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 修改菜品
     */
    @GetMapping("/edit/{menuId}")
    public String edit(@PathVariable("menuId") Integer menuId, ModelMap modelMap) {
        Menu menu = menuService.selectMenuById(menuId);
        List<Category> categories = this.categoryService.selectCategoryList(new Category());
        modelMap.put("menu", menu);
        modelMap.put("categories", categories);
        return prefix + "/edit";
    }

    /**
     * 修改保存菜品
     */
//	@Log(title = "菜品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public ReturnResult editSave(Menu menu) {
        return menuService.updateMenu(menu) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 删除菜品
     */
//	@Log(title = "菜品", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public ReturnResult remove(Integer id) {
        return menuService.deleteMenuById(id) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 删除菜品
     */
//	@Log(title = "菜品", businessType = BusinessType.DELETE)
    @PostMapping("/removeAll")
    @ResponseBody
    public ReturnResult removeAll(Integer[] ids) {
        return menuService.deleteMenuByIds(ids) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

}
