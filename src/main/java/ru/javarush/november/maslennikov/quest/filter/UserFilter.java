package ru.javarush.november.maslennikov.quest.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(filterName = "userFilter", urlPatterns = "/start")
public class UserFilter implements Filter {
    private UserCheck userCheck;
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConf) {
        filterConfig = filterConf;
        userCheck = new UserCheck();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        if (!userCheck.checkName(request.getParameter("gamerName"))) {
            request.setAttribute("blank", true);
            filterConfig.getServletContext().getRequestDispatcher("/").forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }
}
