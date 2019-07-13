package com.scauxg.restaurant.user;

import com.scauxg.restaurant.user.domain.Role;
import com.scauxg.restaurant.user.mapper.RoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleCURDTest {
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void createRole(){
        Role role = new Role();
        role.setRoleName("waiter");
        role.setRoleRemark("");
        roleMapper.insertRole(role);
    }

    @Test
    public void updateRole(){
        Role role = new Role();
        role.setRoleId(1);
        role.setRoleRemark("");
        roleMapper.updateRole(role);
    }

    @Test
    public void readRole(){ System.out.println(roleMapper.selectRoleById(1)); }

    @Test
    public void deleteRole(){
        int result = roleMapper.deleteRoleById(2);
        System.out.println("Result==========" + result);
    }

    @Test
    public void deleteRoleList(){
        Integer ids[] = {3,4};
        System.out.println("result=========" + roleMapper.deleteRoleByIds(ids));
    }
}
