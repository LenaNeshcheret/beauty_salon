package com.lena.repositories;

import com.lena.PostgresConnection;
import com.lena.services.MasterRepository;
import com.lena.util.SortOrder;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MasterRepositoryImpl implements MasterRepository {

    public Master findMaster(String name) throws SQLException {
        Connection connection = PostgresConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select d.id, d.discount_card, d.new_year, d. birth, " +
                "d.march_8, m.id, m.name,  m.phone,  m.adress, m.email, m.profession, m.payment, m.rating  " +
                "from discounts d join masters m on m.discount = d.id where name='" + name + "';");
        Master master = new Master();
        Discount discount = new Discount();
        while (resultSet.next()) {
            discount.setId(resultSet.getInt(1));
            discount.setAccumulateCard(resultSet.getInt(2));
            discount.setNewYearDiscount(resultSet.getInt(3));
            discount.setHappyBirthdayDiscount(resultSet.getInt(4));
            discount.setMarch8Discount(resultSet.getInt(5));
            master.setId(resultSet.getInt(6));
            master.setName(resultSet.getString(7));
            master.setPhone(resultSet.getInt(8));
            master.setAddress(resultSet.getString(9));
            master.setEmail(resultSet.getString(10));
            master.setProfession(resultSet.getString(11));
            master.setPayment(resultSet.getInt(12));
            master.setRating(resultSet.getBigDecimal(13));
            master.setDiscount(discount);
//       client.setBirthday(resultSet.get(8));
        }
        return master;
    }

    public void createMaster(String name, int phone, String adress, String email, int discount, String profession,
                             int payment, int rating) throws SQLException {
        Connection connection = PostgresConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into masters (name,  phone,  adress, email,   discount,  profession, payment, rating)" +
                " VALUES(" + name + "," + phone + "," + adress + "," + email + "," + discount + "," + profession + ","
                + payment + "," + rating + ");";
        statement.executeUpdate(sql);
    }

    @Override
    public boolean updateRating(int masterId, BigDecimal masterRating) throws SQLException {
        Connection connection = PostgresConnection.getConnection();
        Statement statement = connection.createStatement();

        String sql = String.format("update masters set rating=%s where id=%s;", masterRating, masterId);
        return statement.executeUpdate(sql) == 1;
    }

    @Override
    public List<Master> getListMasters(SortOrder sortOrder) throws SQLException {
        Connection connection = PostgresConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = String.format("select name, rating from masters order by rating %s;", sortOrder);
        ResultSet resultSet = statement.executeQuery(sql);
        List<Master> masterList = new ArrayList<>();
        while (resultSet.next()) {
            Master master  = new Master.Builder()
                    .withName(resultSet.getString(1))
                    .withRating(resultSet.getBigDecimal(2))
                    .build();
            masterList.add(master);
        }
        System.out.println(masterList);
        return masterList;
    }
}
