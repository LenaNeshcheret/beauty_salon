package com.lena.controllers;


import com.lena.repositories.Client;
import com.lena.repositories.Record;
import com.lena.services.ClientService;
import com.lena.services.ClientServiceImpl;
import com.lena.services.RecordService;
import com.lena.services.RecordServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
 * Browser sends Http Request to Web Server
 *
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * JEE with Servlets
 *
 * Web Server responds with Http Response
 */

//Java Platform, Enterprise Edition (Java EE) JEE6

//Servlet is a Java programming language class
//used to extend the capabilities of servers
//that host applications accessed by means of
//a request-response programming model.

//1. extends javax.servlet.http.HttpServlet
//2. @WebServlet(urlPatterns = "/login.do")
//3. doGet(HttpServletRequest request, HttpServletResponse response)
//4. How is the response created?

@WebServlet(urlPatterns = "/checkRecords")
public class CheckRecordsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String startDate = httpServletRequest.getParameter("start_date");
        String startTime = httpServletRequest.getParameter("start_time");
        String startDateTime = startDate + "T" + startTime;

        String endDate = httpServletRequest.getParameter("end_date");
        String endTime = httpServletRequest.getParameter("end_time");


        if ((endDate == null || endDate.isEmpty())) {
            processUniqueRecord(httpServletRequest, httpServletResponse, startDateTime);
        } else {
            endTime = (endTime == null || endTime.isEmpty())
                    ? ""
                    : "T" + endTime;
            String endDateTime = endDate + endTime;
            processListRecords(httpServletRequest, httpServletResponse, startDateTime, endDateTime);
        }


    }

    private void processListRecords(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String startDateTime, String endDateTime) throws ServletException, IOException {
        List<Record> listRecords = new ArrayList<>();
        RecordService recordService = new RecordServiceImpl();
        try {
            listRecords = recordService.getRecords(startDateTime, endDateTime);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(listRecords);
        httpServletRequest.setAttribute("listRecords", listRecords);
//todo handle listRecords in makeRecords.jsp
        httpServletRequest.getRequestDispatcher("WEB-INF/views/listRecords.jsp").forward(httpServletRequest, httpServletResponse);

    }

    private void processUniqueRecord(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String startDateTime) throws ServletException, IOException {
        RecordService recordService = new RecordServiceImpl();
        Record record = null;
        try {
            LocalDateTime parsed = LocalDateTime.parse(startDateTime);
            System.out.println("parsed" + parsed);
            record = recordService.getRecord(parsed);
        } catch (Exception e) {
            e.printStackTrace();
        }
        httpServletRequest.setAttribute("record", record);

        httpServletRequest.getRequestDispatcher("WEB-INF/views/makeRecords.jsp").forward(httpServletRequest, httpServletResponse);
    }
}