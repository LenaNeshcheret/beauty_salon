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
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = "/checkAvailableRecords")
public class CheckAvailableRecordsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String startDateTime = DateValidatorUtils.validateDateTime(httpServletRequest, "start_date", "start_time", "07:00");
        String endDateTime = DateValidatorUtils.validateDateTime(httpServletRequest, "end_date", "end_time", "20:00");

        List<LocalDateTime> listAvailableRecords = new ArrayList<>();
        RecordService recordService = new RecordServiceImpl();
        listAvailableRecords = recordService.getAvailableSlotRecords(LocalDateTime.parse(startDateTime), LocalDateTime.parse(endDateTime));
//        System.out.println(listAvailableRecords);
        httpServletRequest.setAttribute("listAvailableRecords", listAvailableRecords);

        httpServletRequest.getRequestDispatcher("WEB-INF/views/listAvailableRecords.jsp").forward(httpServletRequest, httpServletResponse);
    }
}