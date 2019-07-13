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

/**
 * 角色类别表 category
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Getter
@Setter
public class Role {
    private static final long serialVersionUID = 1L;

    /**
     * 角色类别id
     */
    private Integer roleId;
    /**
     * 角色类别
     */
    private String roleName;
    /**
     * 备注
     */
    private String roleRemark;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("roleId", getRoleId())
                .append("roleName", getRoleName())
                .append("roleRemark", getRoleRemark())
                .toString();
    }
}
