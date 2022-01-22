package com.lena.controllers;

import com.lena.repositories.Record;
import com.lena.services.RecordService;
import com.lena.services.RecordServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;


//@WebServlet(urlPatterns = "/checkRecords")
public class CheckAvailableRecordsServlet extends HttpServlet {

//    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
//        String startDate = httpServletRequest.getParameter("start_date");
//        String startTime = httpServletRequest.getParameter("start_time");
//        String endDate = httpServletRequest.getParameter("end_date");
//        String endTime = httpServletRequest.getParameter("end_time");
//
//        String startDateTime = startDate + "T" + startTime;
//        String endDateTime = endDate + "T" + endTime;
//
//        System.out.println(startDateTime);
//        System.out.println(endDateTime);
//
//
//        RecordService recordService = new RecordServiceImpl();
//        Record record = null;
//        try {
//            LocalDateTime parsed = LocalDateTime.parse(startDateTime);
//            System.out.println("parsed" + parsed);
//            record = recordService.getRecords(parsed);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(record);
//        httpServletRequest.setAttribute("record", record);
//
//        httpServletRequest.getRequestDispatcher("WEB-INF/views/makeRecords.jsp").forward(httpServletRequest, httpServletResponse);
//
//    }
}