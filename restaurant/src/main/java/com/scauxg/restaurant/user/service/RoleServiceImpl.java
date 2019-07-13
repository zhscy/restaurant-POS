/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.user.service;

import com.scauxg.restaurant.user.domain.Role;
import com.scauxg.restaurant.user.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色 服务层实现
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 查询角色信息
     *
     * @param roleId 角色ID
     * @return 角色信息
     */
    @Override
    public Role selectRoleById(Integer roleId) {
        return roleMapper.selectRoleById(roleId);
    }

    /**
     * 查询角色列表
     *
     * @param role 角色信息
     * @return 角色集合
     */
    @Override
    public List<Role> selectRoleList(Role role) {
        return roleMapper.selectRoleList(role);
    }

    /**
     * 新增菜品类别
     *
     * @param role 角色信息
     * @return 结果
     */
    @Override
    public int insertRole(Role role) {
        return roleMapper.insertRole(role);
    }

    /**
     * 修改角色
     *
     * @param role 角色信息
     * @return 结果
     */
    @Override
    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    public int deleteRoleById(Integer id) {
        return roleMapper.deleteRoleById(id);
    };

    /**
     * 删除角色对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRoleByIds(Integer[] ids) {
        return roleMapper.deleteRoleByIds(ids);
    }

}
