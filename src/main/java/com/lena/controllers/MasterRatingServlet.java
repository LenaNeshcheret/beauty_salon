package com.lena.controllers;

import com.lena.repositories.Master;
import com.lena.services.MasterService;
import com.lena.services.MasterServiceImpl;
import com.lena.util.SortOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/listMasters")
public class MasterRatingServlet extends HttpServlet {


    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        List<Master> listMasters = new ArrayList<>();
        MasterService masterService = new MasterServiceImpl();
        String string = httpServletRequest.getParameter("sort_order");

        SortOrder sortOrder = SortOrder.valueOf(string);
        try {
            listMasters = masterService.getListMasters(sortOrder);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        httpServletRequest.setAttribute("listMasters", listMasters);

        httpServletRequest.getRequestDispatcher("WEB-INF/views/checkRecords.jsp").forward(httpServletRequest, httpServletResponse);
    }
}