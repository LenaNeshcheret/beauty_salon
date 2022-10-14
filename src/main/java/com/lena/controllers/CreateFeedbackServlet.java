package com.lena.controllers;

import com.lena.repositories.FeedbackRepositoryImpl;
import com.lena.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/createFeedback")

public class CreateFeedbackServlet extends HttpServlet {
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        int recordId = Integer.parseInt(httpServletRequest.getParameter("record_id"));
        String feedback = httpServletRequest.getParameter("feedback");
        int rating = Integer.parseInt(httpServletRequest.getParameter("rating"));
        FeedbackService feedbackService = new FeedbackServiceImpl();
        try {
            feedbackService.createFeedback(recordId, feedback, rating);
        } catch (SQLException e) {
            e.printStackTrace();
        }


//        if (recordId < 0) {
//            throw new IllegalArgumentException("Record does not exist");
//        }
//        if (rating < 0 || rating > 5) {
//            throw new IllegalArgumentException("The record must have rating");
//
//
//        }
        httpServletRequest.getRequestDispatcher("WEB-INF/views/checkRecords.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
