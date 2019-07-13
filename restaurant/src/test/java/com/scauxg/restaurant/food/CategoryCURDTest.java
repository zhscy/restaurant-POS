/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.food;

import com.scauxg.restaurant.food.domain.Category;
import com.scauxg.restaurant.food.mapper.CategoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 菜品分类测试
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryCURDTest {
    @Autowired
    CategoryMapper categoryMapper;

    @Test
    public void createTest() {
        Category category = new Category();
        category.setCtgName("shit");
        System.out.println("result======" + categoryMapper.insertCategory(category));
    }

    @Test
    public void updateTest() {
        Category category = new Category();
        category.setCtgId(1);
        category.setCtgRemark("");
        categoryMapper.updateCategory(category);
    }

    @Test
    public void readTest() {
        System.out.println(categoryMapper.selectCategoryById(1));
    }

    @Test
    public void readListTest() {
        List<Category> categories = categoryMapper.selectCategoryList(new Category());
        for (Category category :
                categories) {
            System.out.println(category);
        }
    }

    @Test
    public void deleteTest() {
        int result = categoryMapper.deleteCategoryById(3);
        System.out.println("result=====" + result);
    }

    @Test
    public void deleteListTest() {
        Integer[] ids = {4, 5};
        System.out.println("result=====" + categoryMapper.deleteCategoryByIds(ids));
    }
}
