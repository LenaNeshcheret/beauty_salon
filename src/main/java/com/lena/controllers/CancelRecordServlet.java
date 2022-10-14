package com.lena.controllers;


import com.lena.repositories.Record;
import com.lena.repositories.RecordRepositoryImpl;
import com.lena.services.RecordRepository;
import com.lena.services.RecordService;
import com.lena.services.RecordServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//to do remove urlPaterns =
@WebServlet(urlPatterns = "/cancelRecord")

public class CancelRecordServlet extends HttpServlet {

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        int recordId = Integer.parseInt(httpServletRequest.getParameter("record_id"));
        RecordService recordService = new RecordServiceImpl();
        boolean resultCancelRecord = recordService.cancelRecord(recordId);
        httpServletRequest.setAttribute("resultCancelRecord", resultCancelRecord);

        httpServletRequest.getRequestDispatcher("WEB-INF/views/cancelRecord.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
