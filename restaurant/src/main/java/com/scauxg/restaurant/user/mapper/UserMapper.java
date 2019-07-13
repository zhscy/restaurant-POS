/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.user.mapper;

import com.scauxg.restaurant.user.VO.UserVO;
import com.scauxg.restaurant.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 员工 数据层
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Repository
public interface UserMapper {
    /**
     * 查询员工账号信息
     *
     * @param userId 员工账号ID
     * @return 员工账号信息
     */
    public UserVO selectUserById(Integer userId);

    /**
     * 查询账号密码
     * @param userTel
     * @return
     */
    public String selectUserPasswordByTel(String userTel);//@Param("userTel")

    /**
     * 查询角色
     * @param userTel
     * @return
     */
    public String selectRoleByTel(String userTel);//@Param("userTel")

    /**
     * 查询员工账号列表
     *
     * @param user 员工账号信息
     * @return 员工账号集合
     */
    public List<UserVO> selectUserList(User user);

    /**
     * 新增员工账号
     *
     * @param user 员工账号信息
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 修改员工账号
     *
     * @param user 员工账号信息
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 删除员工账号
     *
     * @param userId 员工账号ID
     * @return 结果
     */
    public int deleteUserById(Integer userId);

    /**
     * 批量删除员工账号
     *
     * @param userIds 需要删除的员工账号ID
     * @return 结果
     */
    public int deleteUserByIds(Integer[] userIds);

}