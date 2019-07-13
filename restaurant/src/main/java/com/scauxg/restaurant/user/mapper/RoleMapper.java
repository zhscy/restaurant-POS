/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.user.mapper;

import com.scauxg.restaurant.user.domain.Role;
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
public interface RoleMapper {
    /**
     * 查询角色信息
     *
     * @param roleId 角色ID
     * @return 角色信息
     */
    public Role selectRoleById(Integer roleId);

    /**
     * 查询角色列表
     *
     * @param role 角色信息
     * @return 菜品类别集合
     */
    public List<Role> selectRoleList(Role role);

    /**
     * 新增角色
     *
     * @param role 角色信息
     * @return 结果
     */
    public int insertRole(Role role);

    /**
     * 修改角色
     *
     * @param role 角色信息
     * @return 结果
     */
    public int updateRole(Role role);

    /**
     * 删除角色
     *
     * @param roleId 菜品类别ID
     * @return 结果
     */
    public int deleteRoleById(Integer roleId);

    /**
     * 批量删除角色
     *
     * @param roleIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRoleByIds(Integer[] roleIds);

}