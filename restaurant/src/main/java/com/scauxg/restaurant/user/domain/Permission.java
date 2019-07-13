/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/4/7 21:46
 * History:
 */
package com.scauxg.restaurant.user.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 权限
 *
 * @author Yue
 * @create 2019/4/7
 * @since 1.0.0
 */
@Getter
@Setter
public class Permission {
    private Integer permsId;
    private String roleName;
    private String rolePermission;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("permsId", getPermsId())
                .append("roleName", getRoleName())
                .append("permission", getRolePermission())
                .toString();
    }
}
