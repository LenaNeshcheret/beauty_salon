package com.lena.controllers;

import com.lena.repositories.Client;
import com.lena.services.ClientService;
import com.lena.services.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
    public class LogInServlet extends HttpServlet {

    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String login = httpServletRequest.getParameter("login");
        String password = httpServletRequest.getParameter("password");
        ClientService clientService = new ClientServiceImpl();
        Client client = null;
        try

        {
            client = clientService.findClientByLoginAndPassword(login, password);
        } catch(
                Exception e)

        {
            e.printStackTrace();
        }
        System.out.println(client);
        httpServletRequest.setAttribute("client", client);

        httpServletRequest.getRequestDispatcher("WEB-INF/views/checkRecords.jsp").
                forward(httpServletRequest, httpServletResponse);
    }


}
