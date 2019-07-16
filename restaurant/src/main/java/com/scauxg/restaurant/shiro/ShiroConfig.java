/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/4/7 23:09
 * History:
 */
package com.scauxg.restaurant.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.scauxg.restaurant.shiro.realm.CustomRealm;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 配置shiro
 *
 * @author Yue
 * @create 2019/4/7
 * @since 1.0.0
 */
@Configuration
public class ShiroConfig {
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);


        // 身份认证失败，则跳转到登录页面的配置
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 权限认证失败，则跳转到指定页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/permsError");

        // 过滤器配置
        Map<String, String> filerMap = new LinkedHashMap<>();
        // 对静态资源设置匿名访问
        filerMap.put("/lg/**", "anon");
        filerMap.put("/lib/**", "anon");
        filerMap.put("/static/**", "anon");
        filerMap.put("/temp/**", "anon");
        filerMap.put("/entry", "anon");
        filerMap.put("/permsError","anon");

        // 角色拦截
        filerMap.put("/role/add","roles[admin]");
        // 权限拦截
        filerMap.put("/user/add","perms[user:modify]");

//        filerMap.put("/pos/**","anon");

        // 拦截界面
//        filerMap.put("/*", "authc");
//        filerMap.put("/**", "authc");
//        filerMap.put("/", "authc");
        filerMap.put("/*", "user");
        filerMap.put("/**", "user");
        filerMap.put("/", "user");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filerMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 配置安全管理器
     * @param customRealm
     * @return
     */
//    public DefaultWebSecurityManager securityManager(CustomRealm customRealm) {
    @Bean(name="securityManager")
    public SecurityManager securityManager(CustomRealm customRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm);
        // 注入缓存对象
//        securityManager.setCacheManager(ehCacheManager());
        // 注入rememberMeManager
        securityManager.setRememberMeManager(cookieRememberMeManager());
        return securityManager;
    }
    @Bean
    public FormAuthenticationFilter formAuthenticationFilter(){
        FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
        //对应前端的checkbox的name = rememberMe
        formAuthenticationFilter.setRememberMeParam("rememberMe");
        return formAuthenticationFilter;
    }
/*
    @Bean
    public EhCacheManager ehCacheManager() {
        System.out.println("ShiroConfig --> getEhCacheManager()");
        EhCacheManager ehCacheManager = new EhCacheManager();
        ehCacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return ehCacheManager;
    }
*/

    //cookie对象;
    @Bean
    public SimpleCookie rememberMeCookie() {
        System.out.println("ShiroConfig --> rememberMeCookie()");
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");

        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(259200);
        return simpleCookie;
    }

    //cookie管理对象;
    @Bean
    public CookieRememberMeManager cookieRememberMeManager() {
        System.out.println("ShiroConfig --> rememberMeManager()");
        CookieRememberMeManager manager = new CookieRememberMeManager();
        manager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        manager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return manager;
    }

    /**
     * 配置自定义Realm
     * @return
     */
    @Bean
    public CustomRealm customRealm() {
        CustomRealm customRealm = new CustomRealm();
        return customRealm;
    }

    /**
     * 配置ShiroDialect，用于thymeleaf和shiro标签
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }


}
