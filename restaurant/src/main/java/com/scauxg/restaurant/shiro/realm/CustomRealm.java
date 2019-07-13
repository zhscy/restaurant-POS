/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/4/6 11:42
 * History:
 */
package com.scauxg.restaurant.shiro.realm;

import com.scauxg.restaurant.user.VO.UserVO;
import com.scauxg.restaurant.user.service.IPermissionService;
import com.scauxg.restaurant.user.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * 自定义Realm
 *
 * @author Yue
 * @create 2019/4/6
 * @since 1.0.0
 */
public class CustomRealm extends AuthorizingRealm {


    @Autowired
    private IUserService userService;

    @Autowired
    private IPermissionService permissionService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        String username = (String) principalCollection.getPrimaryPrincipal();
        Subject subject = SecurityUtils.getSubject();
        UserVO user = (UserVO) subject.getPrincipal();
        // 从数据库中获取角色数据
        String role = user.getRole();
//        System.out.println("测试Service======" + userService.selectRoleByTel(user.getUserTel()));
        Set<String> permissions = permissionService.selectPermissionByRole(role);
//        for (String perms : permissions) {
//            System.out.println("---------------------perms" + perms);
//        }
//        System.out.println("------授权-------username===" + user.getUserTel());
//        System.out.println("------授权-------role===" + role);
//        System.out.println("fffffffffffffffffff" + userService.selectUserByTel(user.getUserTel()).getRole());

//        Set<String> roles = new HashSet<String>(){{
//            add(role);
//        }};
//        Set<String> roles = getRolesByUserName();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
//        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.addRole(role);

        return simpleAuthorizationInfo;
    }


    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 从主体中传过来的认证信息中获取用户名
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();

        // 通过用户名到数据库中获取凭证
        UserVO user = userService.selectUserByTel(username);
        if (user == null) {
            System.out.println("null---------====" + user);
            return null;
        }
        String password = user.getUserPassword();
//        System.out.println("not null-------password" + password);

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, password, "customRealm");

        // 设置盐
//        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("xiaoming"));

        return authenticationInfo;
    }

}
