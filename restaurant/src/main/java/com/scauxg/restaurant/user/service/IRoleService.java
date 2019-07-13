/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.user.service;

import com.scauxg.restaurant.user.domain.Role;

import java.util.List;

/**
 * 菜品类别 服务层
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
public interface IRoleService {
    /**
     * 查询菜品类别信息
     *
     * @param roleId 菜品类别ID
     * @return 菜品类别信息
     */
    public Role selectRoleById(Integer roleId);

    /**
     * 查询菜品类别列表
     *
     * @param role 菜品类别信息
     * @return 菜品类别集合
     */
    public List<Role> selectRoleList(Role role);

    /**
     * 新增菜品类别
     *
     * @param role 菜品类别信息
     * @return 结果
     */
    public int insertRole(Role role);

    /**
     * 修改菜品类别
     *
     * @param role 菜品类别信息
     * @return 结果
     */
    public int updateRole(Role role);

    public int deleteRoleById(Integer id);

    /**
     * 删除菜品类别信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRoleByIds(Integer[] ids);

}
