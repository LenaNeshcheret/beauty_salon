package com.lena.controllers;


import com.lena.repositories.Record;
import com.lena.services.RecordService;
import com.lena.services.RecordServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static Logger log = LoggerFactory.getLogger(CheckRecordsServlet.class);


    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String startDate = httpServletRequest.getParameter("start_date");
        if(startDate.isEmpty()){
            throw new IllegalArgumentException("Start date do not empty");
        }
        String startDateTime = DateValidatorUtils.validateDateTime(httpServletRequest, "start_date", "start_time", "07:00");
        String endDateTime = DateValidatorUtils.validateDateTime(httpServletRequest, "end_date", "end_time", "20:00");

        String endDate = httpServletRequest.getParameter("end_date");

        List<Record> listRecords = new ArrayList<>();
        RecordService recordService = new RecordServiceImpl();

        try {
            if ((endDate == null || endDate.isEmpty())) {
                LocalDateTime parsed = LocalDateTime.parse(startDateTime);
                listRecords  = recordService.getRecord(parsed);
            }else {
                listRecords = recordService.getRecords(startDateTime, endDateTime);
            }
        } catch (SQLException e){
            log.error("Error during fetching records list");
        }
        httpServletRequest.setAttribute("listRecords", listRecords);
        httpServletRequest.getRequestDispatcher("WEB-INF/views/listRecords.jsp").forward(httpServletRequest, httpServletResponse);
    }
}