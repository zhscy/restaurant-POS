/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/4/7 22:44
 * History:
 */
package com.scauxg.restaurant.shiro;

import com.scauxg.restaurant.user.domain.Permission;
import com.scauxg.restaurant.user.mapper.PermissionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

/**
 * 测试权限
 *
 * @author Yue
 * @create 2019/4/7
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionCURDTest {

    @Autowired
    private PermissionMapper permissionMapper;

    @Test
    public void readPerms() {
        Set<String> set = permissionMapper.selectPermissionByRole("user");
        for (String perms : set) {
            System.out.println("===============" + perms);
        }
    }

    @Test
    public void createPerms() {
        Permission permission = new Permission();
        permission.setRoleName("user");
        permission.setRolePermission("user:modify");
        permissionMapper.insertPerms(permission);
    }

    @Test
    public void updatePerms() {
        Permission permission = new Permission();
        permission.setRoleName("user");
        permission.setRolePermission("user:");
        permissionMapper.updatePerms(permission);
    }

    @Test
    public void deletePerms() {
        int result = permissionMapper.deletePerms(6);
        System.out.println("result=======" + result);
    }

    @Test
    public void deteleList() {
         Integer[] ids= {7,8};
        System.out.println("result=========" + permissionMapper.deletePermsByIds(ids));
    }
}
