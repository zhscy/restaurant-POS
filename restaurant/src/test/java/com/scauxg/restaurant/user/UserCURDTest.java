/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.user;

import com.scauxg.restaurant.user.VO.UserVO;
import com.scauxg.restaurant.user.domain.User;
import com.scauxg.restaurant.user.mapper.UserMapper;
import com.scauxg.restaurant.user.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 菜品分类测试
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCURDTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void createTest() {
        User user = new User();
        user.setUserName("李四");
        user.setUserSex(1);
        user.setUserRole(0);
        user.setUserPassword("123");
        user.setUserTel("13343567372");
        //user.setCtgRemark("");
        userMapper.insertUser(user);
    }

    @Test
    public void updateTest() {
        User user = new User();
        user.setUserName("李四");
        user.setUserSex(0);
        user.setUserRole(1);
        user.setUserPassword("123");
        user.setUserTel("13367589072");
        //user.setCtgRemark("");
        userMapper.updateUser(user);
    }

    @Test
    public void readTest() {
        System.out.println(userMapper.selectUserById(1));
    }

    @Test
    public void readListTest() {
        List<UserVO> users = userMapper.selectUserList(new User());
        for (User user :
                users) {
            System.out.println(user);
        }
    }

    @Test
    public void deleteTest() {
        int result = userMapper.deleteUserById(3);
        System.out.println("result=====" + result);
    }

    @Test
    public void deleteListTest() {
        Integer[] ids = {4, 5};
        System.out.println("result=====" + userMapper.deleteUserByIds(ids));
    }

    @Test
    public void selectUserByTel() {
        System.out.println("==========" + userMapper.selectUserPasswordByTel("1333333333"));
    }

    @Test
    public void selectUserRole() {
        System.out.println("==========" + userMapper.selectRoleByTel("xiaoming"));//userService
    }


    @Autowired
    IUserService userService;
    @Test
    public void selectUser() {
        System.out.println("==============user" + userService.selectUserByTel("jak"));
    }
}
