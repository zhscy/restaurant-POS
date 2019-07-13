/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.order.service;

import com.scauxg.restaurant.order.mapper.ItemMapper;
import com.scauxg.restaurant.order.domain.Item;
import com.scauxg.restaurant.order.VO.ItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户 服务层实现
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Service
public class ItemServiceImpl implements IItemService {
    
    @Autowired
    private ItemMapper itemMapper;

    /**
     * 查询用户信息
     *
     * @param itemId 用户ID
     * @return 用户信息
     */
    @Override
    public ItemVO selectItemById(Integer itemId) {
        return itemMapper.selectItemById(itemId);
    }

    /**
     * 查询用户列表
     *
     * @param item 用户信息
     * @return 用户集合
     */
    @Override
    public List<ItemVO> selectItemList(Item item) {
        return itemMapper.selectItemList(item);
    }

    /**
     * 新增用户
     *
     * @param item 用户信息
     * @return 结果
     */
    @Override
    public int insertItem(Item item) {
        return itemMapper.insertItem(item);
    }

    /**
     * 修改菜品
     *
     * @param item 用户信息
     * @return 结果
     */
    @Override
    public int updateItem(Item item) {
        return itemMapper.updateItem(item);
    }

    public int deleteItemById(Integer id) {
        return itemMapper.deleteItemById(id);
    }
    /**
     * 删除用户对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteItemByIds(Integer[] ids) {
        return itemMapper.deleteItemByIds(ids);
    }

}
