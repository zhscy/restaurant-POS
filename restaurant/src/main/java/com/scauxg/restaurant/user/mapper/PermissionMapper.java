/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/4/7 21:38
 * History:
 */
package com.scauxg.restaurant.user.mapper;

import com.scauxg.restaurant.user.domain.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * 权限
 *
 * @author Yue
 * @create 2019/4/7
 * @since 1.0.0
 */
@Repository
public interface PermissionMapper {

    public Permission selectPermissionById(Integer permsId);

    public Set<String> selectPermissionByRole(String roleName);

    public List<Permission> selectPermissionList(Permission permission);

    public int insertPerms(Permission permission);

    public int updatePerms(Permission permission);

    public int deletePerms(Integer permsId);

    public int deletePermsByIds(Integer[] permsIds);
}
