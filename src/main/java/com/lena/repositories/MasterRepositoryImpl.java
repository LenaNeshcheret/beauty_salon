package com.lena.repositories;

import com.lena.PostgresConnection;
import com.lena.services.MasterRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MasterRepositoryImpl implements MasterRepository {

    public Master findMaster (String name, int phone) throws SQLException {
        Connection connection= PostgresConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select d.id, d.discount_card, d.new_year, d. birth, " +
                "d.march_8, m.id, m.name,  m.phone,  m.adress, m.email, m.profession, m.payment, m.rating  " +
                "from discounts d join masters m on m.discount = d.id where name=" +name + " and phone="+phone +";");
        Master master = new Master();
        Discount discount =new Discount();
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
            master.setRating(resultSet.getInt(13));
            master.setDiscount(discount);
//       client.setBirthday(resultSet.get(8));
        }
        return master;
    }

    public void createMaster (String name, int phone, String adress, String email, int discount,  String profession, int payment, int rating ) throws SQLException {
        Connection connection= PostgresConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into masters (name,  phone,  adress, email,   discount,  profession, payment, rating) VALUES(" +  name + "," + phone + "," + adress + "," + email +"," +  discount+ "," +  profession+ "," +payment+ "," + rating+");" ;
        statement.executeUpdate(sql);
    }
}
