/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.user.service;

import com.scauxg.restaurant.user.domain.User;
import com.scauxg.restaurant.user.mapper.UserMapper;
import com.scauxg.restaurant.user.VO.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 员工账号 服务层实现
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询员工账号信息
     *
     * @param UserId 员工账号ID
     * @return 员工账号信息
     */
    @Override
    public UserVO selectUserById(Integer UserId) {
        return userMapper.selectUserById(UserId);
    }

    /**
     * 查询员工账号列表
     *
     * @param user 员工账号信息
     * @return 员工账号集合
     */
    @Override
    public List<UserVO> selectUserList(User user) {
        return userMapper.selectUserList(user);
    }

    /**
     * 新增员工账号
     *
     * @param user 员工账号信息
     * @return 结果
     */
    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    /**
     * 修改员工账号
     *
     * @param user 员工账号信息
     * @return 结果
     */
    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    /**
     * 批量删除员工账号对象
     *
     * @param id 需要删除的员工账号ID
     * @return 结果
     */
    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    /**
     * 批量删除员工账号对象
     *
     * @param ids 需要删除的员工账号ID
     * @return 结果
     */
    @Override
    public int deleteUserByIds(Integer[] ids) {
        return userMapper.deleteUserByIds(ids);
    }

    /**
     * 通过账号查询用户
     * @param userTel
     * @return
     */
    @Override
    public UserVO selectUserByTel(String userTel) {
        User user = new User();
        user.setUserTel(userTel);
        List<UserVO> list = userMapper.selectUserList(user);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 根据账号查询密码
     * @param userTel
     * @return
     */
    @Override
    public String selectUserPasswordByTel(String userTel) {
        return userMapper.selectUserPasswordByTel(userTel);
    }

    /**
     * 根据账号查询角色
     * @param userTel
     * @return
     */
    @Override
    public String selectRoleByTel(String userTel) {
        return null;
    }

}
