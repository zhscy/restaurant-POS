/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.user.service;

import com.scauxg.restaurant.user.domain.User;
import com.scauxg.restaurant.user.VO.UserVO;

import java.util.List;

/**
 * 员工账号 服务层
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
public interface IUserService
{
	/**
     * 查询员工账号户信息
     * 
     * @param UserId 员工账号ID
     * @return 员工账号信息
     */
	public UserVO selectUserById(Integer UserId);
	
	/**
     * 查询员工账号列表
     * 
     * @param user 员工账号信息
     * @return 员工账号户集合
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
	 * 批量删除员工账号信息
	 *
	 * @param id 需要删除的员工账号ID
	 * @return 结果
	 */
	public int deleteUserById(Integer id);
		
	/**
     * 批量删除员工账号信息
     * 
     * @param ids 需要删除的员工账号ID
     * @return 结果
     */
	public int deleteUserByIds(Integer[] ids);

	public UserVO selectUserByTel(String userTel);

	public String selectUserPasswordByTel(String userTel);

	public String selectRoleByTel(String userTel);


}
