package com.project.controller;

import com.project.pojo.Admin;
import com.project.pojo.User;
import com.project.service.impl.LogoutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LogoutController {
    @Autowired
    private LogoutServiceImpl logoutService;
    @RequestMapping("/logout{logout}")
    public void logOut(@PathVariable("logout") String logout, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String queryString = request.getQueryString();

        if (queryString.endsWith("userLogout")){
                User user = (User)request.getSession().getAttribute("user");
                Integer id = user.getId();
                request.getSession().removeAttribute("user");
                logoutService.logoutUser(id);
                response.sendRedirect("/");
            }
            if(queryString.endsWith("adminLogout")){
                Admin admin = (Admin)request.getSession().getAttribute("admin");
                Integer id = admin.getId();
                request.getSession().removeAttribute("admin");
                logoutService.logoutAdmin(id);
                response.sendRedirect("/");

        }
    }
}
