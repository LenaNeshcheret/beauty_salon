package com.lena.services;

import com.lena.factory.RepositoryFactory;
import com.lena.repositories.Client;
import com.lena.repositories.ClientRepositoryImpl;

import java.sql.SQLException;

public class ClientServiceImpl implements ClientService{


    ClientRepository clientRepository =  RepositoryFactory.create("client", ClientRepository.class);

    @Override
    public void createClient(String name, int phone, String adress, String email, int discount, int total_many) throws SQLException {
        clientRepository.createClient(name, phone, adress, email, discount, total_many);
    }

    @Override
    public Client findClientByNameAndPhone(String name, int phone) {
        try {
            return clientRepository.findClientByNameAndPhone(name, phone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Client findClientByLoginAndPassword(String login, String password) throws SQLException {
        return clientRepository.findClientByLoginAndPassword(login, password);
    }
}
