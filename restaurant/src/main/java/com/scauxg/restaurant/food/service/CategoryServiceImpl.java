/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.food.service;

import com.scauxg.restaurant.food.domain.Category;
import com.scauxg.restaurant.food.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜品类别 服务层实现
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询菜品类别信息
     *
     * @param ctgId 菜品类别ID
     * @return 菜品类别信息
     */
    @Override
    public Category selectCategoryById(Integer ctgId) {
        return categoryMapper.selectCategoryById(ctgId);
    }

    /**
     * 查询菜品类别列表
     *
     * @param category 菜品类别信息
     * @return 菜品类别集合
     */
    @Override
    public List<Category> selectCategoryList(Category category) {
        return categoryMapper.selectCategoryList(category);
    }

    /**
     * 新增菜品类别
     *
     * @param category 菜品类别信息
     * @return 结果
     */
    @Override
    public int insertCategory(Category category) {
        return categoryMapper.insertCategory(category);
    }

    /**
     * 修改菜品类别
     *
     * @param category 菜品类别信息
     * @return 结果
     */
    @Override
    public int updateCategory(Category category) {
        return categoryMapper.updateCategory(category);
    }

    @Override
    public int deleteCategoryById(Integer id) {
        return categoryMapper.deleteCategoryById(id);
    }
    /**
     * 删除菜品类别对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCategoryByIds(Integer[] ids) {
        return categoryMapper.deleteCategoryByIds(ids);
    }

}
