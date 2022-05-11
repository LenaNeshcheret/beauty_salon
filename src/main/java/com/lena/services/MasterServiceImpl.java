package com.lena.services;


import com.lena.repositories.Master;
import com.lena.repositories.MasterRepositoryImpl;
import com.lena.util.SortOrder;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class MasterServiceImpl implements MasterService {
    MasterRepository masterRepository = new MasterRepositoryImpl();

    @Override
    public void createMaster(String name, int phone, String adress, String email, int discount, String profession, int payment, int rating) throws SQLException {
        masterRepository.createMaster(name, phone, adress, email, discount, profession, payment, rating);
        return;
    }


    @Override
    public Master findMaster(String name) {
        Master masterResult = null;
        try {
            masterResult = masterRepository.findMaster(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return masterResult;
    }

    @Override
    public boolean updateRating(int masterId, BigDecimal masterRating)  throws SQLException {
        return masterRepository.updateRating(masterId, masterRating);
    }

    @Override
    public List<Master> getListMasters(SortOrder sortOrder) throws SQLException {

        return masterRepository.getListMasters(sortOrder);
    }


}
