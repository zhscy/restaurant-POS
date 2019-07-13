/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.food.service;

import com.scauxg.restaurant.food.VO.MenuVO;
import com.scauxg.restaurant.food.domain.Menu;

import java.util.List;

/**
 * 菜品 服务层
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
public interface IMenuService
{
	/**
     * 查询菜品信息
     * 
     * @param menuId 菜品ID
     * @return 菜品信息
     */
	public MenuVO selectMenuById(Integer menuId);
	
	/**
     * 查询菜品列表
     * 
     * @param menu 菜品信息
     * @return 菜品集合
     */
	public List<MenuVO> selectMenuList(Menu menu);
	
	/**
     * 新增菜品
     * 
     * @param menu 菜品信息
     * @return 结果
     */
	public int insertMenu(Menu menu);
	
	/**
     * 修改菜品
     * 
     * @param menu 菜品信息
     * @return 结果
     */
	public int updateMenu(Menu menu);

	public int deleteMenuById(Integer id);
	/**
     * 删除菜品信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMenuByIds(Integer[] ids);
	
}
