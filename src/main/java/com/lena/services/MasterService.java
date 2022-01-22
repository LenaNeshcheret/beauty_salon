package com.lena.services;

import com.lena.repositories.Master;

import java.sql.SQLException;

public interface MasterService {
    void createMaster(String name, int phone, String adress, String email,
                      int discount, String profession, int payment,
                      int rating) throws SQLException;

    Master findMaster(String name, int phone) throws Exception;

}
