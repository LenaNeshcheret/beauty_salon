package com.lena.services;

import com.lena.PostgresConnection;
import com.lena.exceptions.BusyTimeRecordException;
import com.lena.repositories.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepositaryImpl implements UserRepository {
    @Override
    public User checkUserLoginPassword(String login, String password) throws SQLException {
//        Connection connection = PostgresConnection.getConnection();
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery( "select * from clients where  login = "+ login+ ", password ="+password+
//                "Union  select * from master were login = "+ login+ ", password ="+password+";");
//
      return null;
    }

}

