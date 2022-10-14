package com.lena.services;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;

public interface FeedbackRepository {

    boolean createFeedback(LocalDateTime date, int clientId, int masterId, String feedback, int rating) throws SQLException;

    BigDecimal getFeedbackRating(int masterId) throws SQLException;
}
