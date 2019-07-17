package com.seauf.webconfig;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @description:
 * @author: lynn
 * @create: 2019/07/16
 */
@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession session = request.getSession();

        //判断是否已有该用户登录的session
        if (false) {
            return true;
        }

        //跳转到登录页
        String url = "/login.html";
        response.sendRedirect(url);
        return false;
    }
}
