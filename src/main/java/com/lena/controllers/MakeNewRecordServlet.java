package com.lena.controllers;


import com.lena.exceptions.BusyTimeRecordException;
import com.lena.repositories.Record;
import com.lena.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/makeNewRecord")

public class MakeNewRecordServlet extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String dateStr = httpServletRequest.getParameter("date");
        String clientName = httpServletRequest.getParameter("clientName");
        int phoneClient = Integer.parseInt(httpServletRequest.getParameter("clientPhone"));
        String masterName = httpServletRequest.getParameter("masterName");
        LocalDateTime dateTime = LocalDateTime.parse(dateStr);

        RecordService recordService = new RecordServiceImpl();
        Record record = null;
        try {
            record = recordService.createRecord(dateTime, clientName, phoneClient, masterName);
            httpServletRequest.setAttribute("record", record);
        } catch (BusyTimeRecordException e) {
            httpServletRequest.setAttribute("error", "Record already exists");
        }



        httpServletRequest.getRequestDispatcher("WEB-INF/views/done.jsp").forward(httpServletRequest, httpServletResponse);

    }
}