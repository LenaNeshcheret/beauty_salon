package com.lena.services;

import com.lena.repositories.Client;
import com.lena.repositories.User;

import java.sql.SQLException;

public interface UserRepository {


   User checkUserLoginPassword (String login, String password) throws SQLException;

}
