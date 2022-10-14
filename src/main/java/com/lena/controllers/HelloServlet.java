package com.lena.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
//        String login = httpServletRequest.getParameter("login");
//        String password=httpServletRequest.getParameter("password");
//
        httpServletRequest.getRequestDispatcher("WEB-INF/views/login.jsp").forward(httpServletRequest,httpServletResponse);
    }
    //
//        httpServletRequest.getRequestDispatcher("WEB-INF/views/login.jsp").forward(httpServletRequest, httpServletResponse);
//    //TODO

}
