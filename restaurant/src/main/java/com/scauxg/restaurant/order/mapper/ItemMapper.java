/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.order.mapper;

import com.scauxg.restaurant.order.domain.Item;
import com.scauxg.restaurant.order.VO.ItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 菜品 数据层
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Repository
public interface ItemMapper {
    /**
     * 查询菜品信息
     *
     * @param itemId 菜品ID
     * @return 菜品信息
     */
    public ItemVO selectItemById(Integer itemId);

    /**
     * 查询菜品列表
     *
     * @param item 菜品信息
     * @return 菜品集合
     */
    public List<ItemVO> selectItemList(Item item);

    /**
     * 新增菜品
     *
     * @param item 菜品信息
     * @return 结果
     */
    public int insertItem(Item item);

    /**
     * 修改菜品
     *
     * @param item 菜品信息
     * @return 结果
     */
    public int updateItem(Item item);

    /**
     * 删除菜品
     *
     * @param itemId 菜品ID
     * @return 结果
     */
    public int deleteItemById(Integer itemId);

    /**
     * 批量删除菜品
     *
     * @param itemIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteItemByIds(Integer[] itemIds);

}