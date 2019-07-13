/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.food.service;

import com.scauxg.restaurant.food.domain.Category;

import java.util.List;

/**
 * 菜品类别 服务层
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
public interface ICategoryService {
    /**
     * 查询菜品类别信息
     *
     * @param ctgId 菜品类别ID
     * @return 菜品类别信息
     */
    public Category selectCategoryById(Integer ctgId);

    /**
     * 查询菜品类别列表
     *
     * @param category 菜品类别信息
     * @return 菜品类别集合
     */
    public List<Category> selectCategoryList(Category category);

    /**
     * 新增菜品类别
     *
     * @param category 菜品类别信息
     * @return 结果
     */
    public int insertCategory(Category category);

    /**
     * 修改菜品类别
     *
     * @param category 菜品类别信息
     * @return 结果
     */
    public int updateCategory(Category category);

    public int deleteCategoryById(Integer id);
    /**
     * 删除菜品类别信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCategoryByIds(Integer[] ids);

}
