package com.lena.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String login = servletRequest.getParameter("login");
        String password = servletRequest.getParameter("password");
//
        HttpSession session =((HttpServletRequest)servletRequest).getSession(false);
        session.setAttribute("login", login);
        session.setAttribute("password", password);
//
//        boolean isLoggedIn = (session != null && session.getAttribute("client") != null);
//
//        if (isLoggedIn ) {
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/checkRecords");
            dispatcher.forward(servletRequest, servletResponse);
//        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
