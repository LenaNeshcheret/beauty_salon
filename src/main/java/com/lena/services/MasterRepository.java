package com.lena.services;

import com.lena.repositories.Client;
import com.lena.repositories.Master;

import java.sql.SQLException;

public interface MasterRepository {

    Master findMaster(String name, int phone) throws SQLException;

    void createMaster(String name, int phone, String address, String email, int discount,  String profession, int payment, int rating ) throws SQLException;
}
