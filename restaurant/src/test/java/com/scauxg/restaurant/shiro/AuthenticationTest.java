/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/4/5 23:32
 * History:
 */
package com.scauxg.restaurant.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * 认证
 *
 * @author Yue
 * @create 2019/4/5
 * @since 1.0.0
 */
public class AuthenticationTest {

    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser() {
        simpleAccountRealm.addAccount("Mark", "123456", "admin", "user");
    }

    @Test
    public void testAuthenticationTest() {
        // 1 构建SecurityManager构建
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        // 2 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Mark", "123456");
        subject.login(token);

        System.out.println("isAuthenticated===" + subject.isAuthenticated());

//        subject.logout();
//        System.out.println("isAuthenticated===" + subject.isAuthenticated());

        subject.checkRoles("user");

    }

}
