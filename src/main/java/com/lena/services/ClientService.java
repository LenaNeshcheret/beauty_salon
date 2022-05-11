package com.lena.services;

import com.lena.repositories.Client;

import java.sql.SQLException;

public interface ClientService {
    void createClient(String name, int phone, String adress, String email, int discount, int total_many) throws SQLException;

     Client findClientByNameAndPhone(String name, int phone);

    Client findClientByLoginAndPassword(String login, String password) throws SQLException;
}
