/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/4/7 23:12
 * History:
 */
package com.scauxg.restaurant.user.service;

import com.scauxg.restaurant.user.domain.Permission;
import com.scauxg.restaurant.user.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * 权限
 *
 * @author Yue
 * @create 2019/4/7
 * @since 1.0.0
 */
@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Permission selectPermissionById(Integer permsId) {
        return permissionMapper.selectPermissionById(permsId);
    }

    @Override
    public Set<String> selectPermissionByRole(String roleName) {
        return permissionMapper.selectPermissionByRole(roleName);
    }

    @Override
    public List<Permission> selectPermissionList(Permission permission) {
        return permissionMapper.selectPermissionList(permission);
    }

    @Override
    public int insertPerms(Permission permission) {
        return permissionMapper.insertPerms(permission);
    }

    @Override
    public int updatePerms(Permission permission) {
        return permissionMapper.updatePerms(permission);
    }

    @Override
    public int deletePerms(Integer permsId) {
        return permissionMapper.deletePerms(permsId);
    }

    @Override
    public int deletePermsByIds(Integer[] permsIds) {
        return permissionMapper.deletePermsByIds(permsIds);
    }

}
