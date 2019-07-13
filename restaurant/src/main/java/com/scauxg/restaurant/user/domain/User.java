/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.user.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 菜品表 menu
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 员工id
     */
    private Integer userId;
    /**
     * 员工名字
     */
    private String userName;
    /**
     * 员工性别
     */
    private Integer userSex;
    /**
     * 员工权限
     */
    private Integer userRole;
    /**
     * 员工登入密码
     */
    private String userPassword;
    /**
     * 员工登入密码
     */
    private String userTel;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("userId", getUserId())
                .append("userName", getUserName())
                .append("userSex", getUserSex())
                .append("userRole", getUserRole())
                .append("userPassword", getUserPassword())
                .append("userTel", getUserTel())
                .toString();
    }
}
