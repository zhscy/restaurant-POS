/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.order.service;

import com.scauxg.restaurant.order.domain.Item;
import com.scauxg.restaurant.order.VO.ItemVO;

import java.util.List;

/**
 * 用户 服务层
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
public interface IItemService
{
	/**
     * 查询用户信息
     * 
     * @param itemId 用户ID
     * @return 用户信息
     */
	public ItemVO selectItemById(Integer itemId);
	
	/**
     * 查询用户列表
     * 
     * @param item 用户信息
     * @return 用户集合
     */
	public List<ItemVO> selectItemList(Item item);
	
	/**
     * 新增用户
     * 
     * @param item 用户信息
     * @return 结果
     */
	public int insertItem(Item item);
	
	/**
     * 修改用户
     * 
     * @param item 用户信息
     * @return 结果
     */
	public int updateItem(Item item);

	public int deleteItemById(Integer id);
		
	/**
     * 删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteItemByIds(Integer[] ids);
	
}
