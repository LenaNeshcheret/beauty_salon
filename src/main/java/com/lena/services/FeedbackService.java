package com.lena.services;

import java.sql.SQLException;

public interface FeedbackService {
    boolean createFeedback(int recordId, String feedback, int rating) throws SQLException;


}
