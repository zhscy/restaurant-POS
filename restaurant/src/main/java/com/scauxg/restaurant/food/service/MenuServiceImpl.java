/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.food.service;

import com.scauxg.restaurant.food.VO.MenuVO;
import com.scauxg.restaurant.food.domain.Menu;
import com.scauxg.restaurant.food.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜品 服务层实现
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 查询菜品信息
     *
     * @param menuId 菜品ID
     * @return 菜品信息
     */
    @Override
    public MenuVO selectMenuById(Integer menuId) {
        return menuMapper.selectMenuById(menuId);
    }

    /**
     * 查询菜品列表
     *
     * @param menu 菜品信息
     * @return 菜品集合
     */
    @Override
    public List<MenuVO> selectMenuList(Menu menu) {
        return menuMapper.selectMenuList(menu);
    }

    /**
     * 新增菜品
     *
     * @param menu 菜品信息
     * @return 结果
     */
    @Override
    public int insertMenu(Menu menu) {
        return menuMapper.insertMenu(menu);
    }

    /**
     * 修改菜品
     *
     * @param menu 菜品信息
     * @return 结果
     */
    @Override
    public int updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }

    @Override
    public int deleteMenuById(Integer id) {
        return menuMapper.deleteMenuById(id);
    }
    /**
     * 删除菜品对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMenuByIds(Integer[] ids) {
        return menuMapper.deleteMenuByIds(ids);
    }

}
