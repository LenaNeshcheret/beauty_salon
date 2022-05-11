package com.lena.repositories;

import com.lena.PostgresConnection;
import com.lena.services.FeedbackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;

public class FeedbackRepositoryImpl implements FeedbackRepository {
//    private static Logger log = LoggerFactory.getLogger(FeedbackRepositoryImpl.class);

    @Override
    public boolean createFeedback(LocalDateTime date, int clientId, int masterId, String feedback, int rating) throws SQLException {
        try (Connection connection = PostgresConnection.getConnection()) {

            String sgl = "insert into feedbacks (date, feedback, client_id, master_id, rating) values (?, ?, ?, ?, ?);";

            PreparedStatement preparedStatement = connection.prepareStatement(sgl);
            preparedStatement.setTimestamp(1, Timestamp.valueOf(date));
            preparedStatement.setString(2,feedback);
            preparedStatement.setInt(3, clientId);
            preparedStatement.setInt(4, masterId);
            preparedStatement.setInt(5, rating);

            return preparedStatement.executeUpdate() == 1;
        }
    }

    @Override
    public BigDecimal getFeedbackRating(int masterId) throws SQLException {
        try (Connection connection = PostgresConnection.getConnection()) {

            String sql = "select AVG(rating) from feedbacks where master_id= ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, masterId);

            ResultSet resultSet = preparedStatement.executeQuery(sql);


            BigDecimal feedbackRating = null;
            while (resultSet.next()) {
                feedbackRating = resultSet.getBigDecimal(1);
            }
            return feedbackRating;
        }
    }
}

