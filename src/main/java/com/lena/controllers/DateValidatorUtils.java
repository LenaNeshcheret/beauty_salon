package com.lena.controllers;

import javax.servlet.http.HttpServletRequest;

public class DateValidatorUtils {

    public static String validateDateTime(HttpServletRequest httpServletRequest, String start_date, String start_time, String startDefault) {
        String startDate = httpServletRequest.getParameter(start_date);
//        if(start_date.isEmpty()){
//            throw new IllegalArgumentException("Start date do not empty");
//        }
        String startTime = httpServletRequest.getParameter(start_time);
        if (startTime.isEmpty()) {
            startTime = startDefault;
        }
        return formatDate(startDate, startTime);
    }

    private static String formatDate(String startDate, String startTime) {
        return startDate + "T" + startTime;
    }
}
