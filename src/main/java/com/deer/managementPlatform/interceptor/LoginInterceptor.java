package com.deer.managementPlatform.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Star
 * @version 1.0
 * @date 2020/10/18 15:46
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI();
        // 这里是在登陆成功后放入session的用户信息
        String userId = (String) request.getSession().getAttribute("user");
        System.err.println(userId);
        // 这里就是判断你访问的路径以及是否存在登陆信息
        if (userId == null){
            // 这个是被拦截后执行，直接重定向到指定页面，我这里是首页也就是登陆页
            response.sendRedirect(request.getContextPath() + "/user/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
