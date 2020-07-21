package com.project.common.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {

    //shiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {

        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /*
            anon: 无需认证就可访问
            authc：必须认证才能访问
            user：必须拥有记住我功能才能访问
            perms: 拥有对某个资源的权限才能访问
            role:拥有某个角色权限才能访问
       */

        Map<String, String> filterMap = new LinkedHashMap<>();


        //授权
//       filterMap.put("/user/**", "roles[user]");
//       filterMap.put("/admin/**", "roles[admin]");

       // filterMap.put("/user/finance/**","perms[user:finance]");
        filterMap.put("/user/finance/toChangeMoney","perms[user:changeMoney]");
        filterMap.put("/user/finance/toPayMoney","perms[user:payMoney]");
        filterMap.put("/user/finance/toTermFinancial","perms[user:termFinancial]");
        filterMap.put("/user/finance/toFundProduct","perms[user:fundProduct]");
        filterMap.put("/user/finance/toBank","perms[user:bank]");
       // filterMap.put("/user/tools/**","perms[user:tools]");
        filterMap.put("/user/tools/toApplyLoan","perms[user:loan]");
        filterMap.put("/user/tools/toRecord","perms[user:record]");
       // filterMap.put("/admin/userinfo/**","perms[admin:userInfo]");
        filterMap.put("/admin/userinfo/toBankCard","perms[admin:bankCard]");
        filterMap.put("/admin/userinfo/toReputation","perms[admin:reputation]");
        filterMap.put("/admin/userinfo","perms[admin:userInfoElse]");
       // filterMap.put("/admin/finance/**","perms[admin:finance]");
        filterMap.put("/admin/finance/toChangeMoney","perms[admin:changeMoney]");
        filterMap.put("admin/finance/toPayMoney","perms[admin:payMoney]");
        filterMap.put("/admin/finance/toTermFinancial","perms[admin:termFinancial]");
        filterMap.put("/admin/finance/toFundProduct","perms[admin:fundProduct]");
        filterMap.put("/admin/finance/toBank","perms[admin:bank]");
       // filterMap.put("/admin/permission/**","perms[admin:permission]");
        filterMap.put("/admin/permission/toUserPermissions","perms[admin:userPermissions]");
        filterMap.put("/admin/permission/toAdminPermissions","perms[admin:adminPermissions]");
       // filterMap.put("/admin/loan/**","perms[admin:loan]");
        filterMap.put("/admin/loan/toLoanexam","perms[admin:loanExam]");
        filterMap.put("/admin/loan/toLoaninfo","perms[admin:loanInfo]");
        //过滤请求
        filterMap.put("/error/**", "anon");
        filterMap.put("/", "anon");
        filterMap.put("/index", "anon");
        filterMap.put("/register", "anon");
        filterMap.put("/login/**", "anon");
        filterMap.put("/asserts/**", "anon");
        filterMap.put("/bootstrap/**", "anon");
        filterMap.put("/images/**", "anon");
        filterMap.put("/lyear/**", "anon");
        filterMap.put("/js/**", "anon");
        filterMap.put("/login/loginVerifyUsername/**","anon");
        filterMap.put("/login/verifyLogin","anon");


         filterMap.put("/admin/main","anon");
         filterMap.put("/user/main","anon");
         filterMap.put("/user/**", "authc");
         filterMap.put("/admin/**", "authc");

        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截
        // filterMap.put("/**", "authc");

        //设置登出
        //filterMap.put("/logout", "logout");

        bean.setFilterChainDefinitionMap(filterMap);
        //设置登录请求（认证界面）
        bean.setLoginUrl("/");
        //设置未授权页面
        bean.setUnauthorizedUrl("/error/401");

        return bean;
    }

    //DafaultWebSecurituManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);

        return securityManager;
    }

    //创建realm对象 ，需要自定义
    @Bean(name = "userRealm")
    public UserRealm userRealm() {
        return new UserRealm();
    }

    //整合thymeleaf
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }


}
