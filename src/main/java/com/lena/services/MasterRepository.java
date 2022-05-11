package com.lena.services;

import com.lena.repositories.Client;
import com.lena.repositories.Master;
import com.lena.util.SortOrder;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface MasterRepository {

    Master findMaster(String name) throws SQLException;

    void createMaster(String name, int phone, String address, String email, int discount,  String profession,
                      int payment, int rating ) throws SQLException;

    boolean updateRating(int masterId, BigDecimal masterRating) throws SQLException;

    List<Master> getListMasters(SortOrder sortOrder) throws SQLException;
}
