/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/4/6 11:49
 * History:
 */
package com.scauxg.restaurant.shiro;

import com.scauxg.restaurant.shiro.realm.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 自定义Realm测试
 *
 * @author Yue
 * @create 2019/4/6
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomRealmTest {
    @Test
    public void testAuthenticationTest() {
        CustomRealm customRealm = new CustomRealm();

        // 1 构建SecurityManager构建
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);


        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        // 算法名称
        matcher.setHashAlgorithmName("md5");
        // 加密次数
        matcher.setHashIterations(1);

        // 需要在自定义的realm中设置matcher对象
        customRealm.setCredentialsMatcher(matcher);

        // 2 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("1333333333", "123456");
        subject.login(token);

        System.out.println("isAuthenticated===" + subject.isAuthenticated());

//        subject.checkRoles("user", "admin");
//        subject.checkPermissions("user:add","user:delete");
    }
}
