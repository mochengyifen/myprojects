package com.zhhong.mochen.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author 董仁亮
 * @date 2019-11-06 17:12
 * @Description:登录过滤器
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        Map<String, Object> user = (Map<String, Object>) session.getAttribute("user");
        String uri = request.getRequestURI();
        String[] urls = {"login", "emp/login","emp/sendSms",
                ".js",
                ".css",
                ".ico",
                ".jpg",
                ".png",
                ".ttf",
                ".woff"};
        boolean flag = true;
        for (String str : urls) {
            if (uri.indexOf(str) != -1) {
                flag = false;
                break;
            }
        }
        if (flag) {
            if (user != null) {
                chain.doFilter(req, resp);
            } else {
                response.sendRedirect("http://" + request.getHeader("Host") + "/mochenManagerWeb/login.html");
            }
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
