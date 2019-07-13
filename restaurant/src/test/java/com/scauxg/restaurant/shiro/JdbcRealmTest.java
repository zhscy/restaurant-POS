/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/4/6 9:41
 * History:
 */
package com.scauxg.restaurant.shiro;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * JdbcRealm
 *
 * @author Yue
 * @create 2019/4/6
 * @since 1.0.0
 */
public class JdbcRealmTest {
    DruidDataSource druidDataSource = new DruidDataSource();
    {
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/restaurant?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("wohua");
    }

    @Test
    public void testAuthenticationTest() {
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(druidDataSource);
        // 权限开关，默认为false
        jdbcRealm.setPermissionsLookupEnabled(true);

        // 使用自定义sql语句
        String sql = "select user_password from user where user_tel = ?";
        jdbcRealm.setAuthenticationQuery(sql);

        String roleSql = "select role_name from user u join role r on u.user_role = r.role_id where user_tel = ?";
        jdbcRealm.setUserRolesQuery(roleSql);

        String permissionSql = "select role_permission from permission where role_name = ?";
        jdbcRealm.setPermissionsQuery(permissionSql);

        // 1 构建SecurityManager构建
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);

        // 2 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("1333333333", "123456");
        subject.login(token);

        System.out.println("isAuthenticated===" + subject.isAuthenticated());

//        subject.logout();

        subject.checkRoles("admin");

        subject.checkPermissions("user:modify");

    }

}
