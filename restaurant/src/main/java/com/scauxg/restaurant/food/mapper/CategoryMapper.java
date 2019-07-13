/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.food.mapper;

import com.scauxg.restaurant.food.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜品类别 数据层
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Repository
public interface CategoryMapper {
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

    /**
     * 删除菜品类别
     *
     * @param ctgId 菜品类别ID
     * @return 结果
     */
    public int deleteCategoryById(Integer ctgId);

    /**
     * 批量删除菜品类别
     *
     * @param ctgIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCategoryByIds(Integer[] ctgIds);

}