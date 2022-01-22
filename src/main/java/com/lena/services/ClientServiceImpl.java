package com.lena.services;

import java.sql.SQLException;


import com.lena.repositories.Client;
import com.lena.repositories.ClientRepositoryImpl;

public class ClientServiceImpl implements ClientService {
    ClientRepository clientRepository = new ClientRepositoryImpl();

    @Override
    public void createClient(String name, int phone, String adress, String email,  int discount, int total_many) throws SQLException {
        clientRepository.createClient(name, phone, adress, email, discount, total_many);
        return;
    }



    @Override
    public Client findClient(String name, int phone) throws Exception {
        Client clintResult = clientRepository.getClient(name, phone);
        return clintResult;
    }


}
