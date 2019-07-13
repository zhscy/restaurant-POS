/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/4/5 0:07
 * History:
 */
package com.scauxg.restaurant.user.VO;

import com.scauxg.restaurant.user.domain.User;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 权限数据展示包装类
 *
 * @author Yue
 * @create 2019/4/5
 * @since 1.0.0
 */
public class UserVO extends User {
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("role", getRole())
                .append("userId", getUserId())
                .append("userName", getUserName())
                .append("userSex", getUserSex())
                .append("userPassword", getUserPassword())
                .append("userTel", getUserTel())
                .toString();
    }
}
