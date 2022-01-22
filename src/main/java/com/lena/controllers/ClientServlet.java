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

@WebServlet(urlPatterns = "/client")
public class ClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String firstName = httpServletRequest.getParameter("first_name");
        int phone = Integer.parseInt(httpServletRequest.getParameter("phone"));
        ClientService clientService = new ClientServiceImpl();
        Client client = null;
        try {
            client = clientService.findClient(firstName, phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(client);
        httpServletRequest.setAttribute("client", client);

        httpServletRequest.getRequestDispatcher("WEB-INF/views/client.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
