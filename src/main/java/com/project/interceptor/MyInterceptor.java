package com.project.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor{
    @Override
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        Object admin = request.getSession().getAttribute("admin");

        String servletPath = request.getServletPath();
        if (servletPath.startsWith("/admin")) {
            if ((admin != null)) {
                return true;
            } else {

                response.sendRedirect("/");
                return false;
            }
        }
        if (servletPath.startsWith("/user")){
            if ((user != null)) {
                return true;
            } else {

                response.sendRedirect("/");
                return false;
            }
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}
