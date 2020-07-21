package com.project.common.shiro;


//import com.project.common.LockHelper;
import com.project.pojo.Admin;
import com.project.pojo.AdminPermissions;
import com.project.pojo.User;
import com.project.pojo.UserPermissions;
import com.project.service.AdminPermissionsService;
import com.project.service.AdminMainService;
import com.project.service.UserPermissionsService;
import com.project.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSession;
import java.util.List;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    @Autowired
    AdminMainService adminMainService;
    @Autowired
    UserPermissionsService userPermissionsService;
    @Autowired
    AdminPermissionsService adminPermissionsService;
    boolean flagadmin = false;
    boolean flaguser = false;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //System.out.println("执行了=>授权doGetAuthorizationInfo");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

//        info.addStringPermission("user:add");
        //获取当前登录的对象
        Subject subject1 = SecurityUtils.getSubject();

        Admin admin = (Admin)subject1.getSession().getAttribute("admin");
        //Subject subject = SecurityUtils.getSubject();
        // String currentAdminUsername = (String) subject.getPrincipal();

        if (flagadmin){
            //SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //Subject subject1 = SecurityUtils.getSubject();
            //Subject subject = SecurityUtils.getSubject();
            info.addRole("admin");
            info.addRole("user");
            List<AdminPermissions> list = adminPermissionsService.selectAdminPermissionsById(1);

            for (AdminPermissions ap:list) {
                info.addStringPermission(ap.getPermission());
            }


        }

        //String currentUserUsername = (String) subject.getPrincipal();
        //User user = userService.selectUserByTerms(currentUserUsername);
        User user = (User)subject1.getSession().getAttribute("user");
        if (flaguser){
            //SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRole("user");
            List<UserPermissions> list = userPermissionsService.selectUserPermissionsById(1);


            for (UserPermissions up:list) {
                info.addStringPermission(up.getPermission());
            }

        }


        //info.addStringPermission(currentUser.getPrams());

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {


        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        //从token中取到用户名再去查用户密码
        //User user = userService.queryUserByName(userToken.getUsername());
        Admin admin = adminMainService.selectAdminByTerms(userToken.getUsername());
        if (admin!=null){
            ((UsernamePasswordToken) token).setRememberMe(true);
            Subject currentSubject = SecurityUtils.getSubject();
            Session session = currentSubject.getSession();
            admin.setStatus(1);
            //adminMainService.(admin);
            session.setAttribute("admin", admin);
            System.out.println("执行了=>认证=>"+admin.getUsername()+"登录进入系统");
            flagadmin=true;
            return new SimpleAuthenticationInfo(admin.getUsername(),admin.getPassword(),"");

        }
        User user = userService.selectUserByTerms(userToken.getUsername());
        if (user != null) {
            ((UsernamePasswordToken) token).setRememberMe(true);
            Subject currentSubject = SecurityUtils.getSubject();
            Session session = currentSubject.getSession();
            user.setStatus(1);
            //userService.updateUser(user);
            session.setAttribute("user", user);
            flaguser=true;
            System.out.println("执行了=>认证=>"+user.getUsername()+"登录进入系统");
            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), "");

        }


        return null;
    }
}
