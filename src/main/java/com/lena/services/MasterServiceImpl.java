package com.lena.services;


import com.lena.repositories.Master;
import com.lena.repositories.MasterRepositoryImpl;

import java.sql.SQLException;

public class MasterServiceImpl implements MasterService {
        MasterRepository masterRepository = new MasterRepositoryImpl();

        @Override
        public void createMaster(String name, int phone, String adress, String email, int discount,  String profession, int payment, int rating) throws SQLException {
            masterRepository.createMaster (name, phone, adress, email, discount, profession, payment, rating);
            return;
        }



    @Override
    public Master findMaster(String name, int phone) throws Exception {
        Master masterResult = masterRepository.findMaster(name, phone);
        return masterResult;
    }


}
