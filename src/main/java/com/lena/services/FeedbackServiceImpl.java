package com.lena.services;


import com.lena.repositories.FeedbackRepositoryImpl;
import com.lena.repositories.Record;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {

    @Override
    public boolean createFeedback(int recordId, String feedback, int rating) throws SQLException {
//todo
        RecordService recordService = new RecordServiceImpl();
        Record record = recordService.getRecord(recordId);
        FeedbackRepository feedbackRepository = new FeedbackRepositoryImpl();
        int masterId = record.getMaster().getId();
        feedbackRepository.createFeedback(record.getDate(), record.getClient().getId(), masterId, feedback, rating);
        BigDecimal masterRating = feedbackRepository.getFeedbackRating(masterId);
        MasterService masterService = new MasterServiceImpl();
        return masterService.updateRating(masterId, masterRating);
    }
}


