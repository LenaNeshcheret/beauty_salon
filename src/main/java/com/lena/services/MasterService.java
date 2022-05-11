package com.lena.services;

import com.lena.repositories.Master;
import com.lena.util.SortOrder;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface MasterService {
    void createMaster(String name, int phone, String adress, String email,
                      int discount, String profession, int payment,
                      int rating) throws SQLException;

    Master findMaster(String name) ;

    boolean updateRating(int masterId, BigDecimal masterRating) throws SQLException;

    List<Master> getListMasters(SortOrder sortOrder) throws SQLException;
}
