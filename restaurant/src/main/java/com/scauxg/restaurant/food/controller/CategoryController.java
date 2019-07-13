/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.food.controller;

import com.scauxg.restaurant.common.ReturnResult;
import com.scauxg.restaurant.food.domain.Category;
import com.scauxg.restaurant.food.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import com.ruoyi.framework.aspectj.lang.annotation.Log;

/**
 * 菜品类别 信息操作处理
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
    private String prefix = "category";

    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    public String category() {
        return prefix + "/category";
    }

    /**
     * 查询菜品类别列表
     */
    @RequestMapping("/list")
    public String list(Category category, ModelMap modelMap) {
        List<Category> categories = categoryService.selectCategoryList(category);
        modelMap.put("categories", categories);
        return prefix + "/category";
    }

    /**
     * 新增菜品类别
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存菜品类别
     */
//	@Log(title = "菜品类别", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public ReturnResult addSave(Category category) {
        return categoryService.insertCategory(category) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 修改菜品类别
     */
    @GetMapping("/edit/{ctgId}")
    public String edit(@PathVariable("ctgId") Integer ctgId, ModelMap mmap) {
        Category category = categoryService.selectCategoryById(ctgId);
        mmap.put("category", category);
        return prefix + "/edit";
    }

    /**
     * 修改保存菜品类别
     */
//	@Log(title = "菜品类别", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public ReturnResult editSave(Category category) {
        return categoryService.updateCategory(category) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 删除菜品类别
     */
//	@Log(title = "菜品类别", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public ReturnResult remove(Integer id) {
        return categoryService.deleteCategoryById(id) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 删除菜品类别
     */
//	@Log(title = "菜品类别", businessType = BusinessType.DELETE)
    @PostMapping("/removeAll")
    @ResponseBody
    public ReturnResult removeAll(Integer[] ids) {
        return categoryService.deleteCategoryByIds(ids) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    @PostMapping("/test")
    @ResponseBody
    public String test() {
        return "OK";
    }

}
