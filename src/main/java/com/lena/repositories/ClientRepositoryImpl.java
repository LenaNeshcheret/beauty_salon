package com.lena.repositories;

import com.lena.PostgresConnection;
import com.lena.services.ClientRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ClientRepositoryImpl implements ClientRepository {

    public Client getClient(String name, int phone) throws SQLException {
        Connection connection = PostgresConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select d.id, d.discount_card, d.new_year, d. birth, d.march_8, c.id, c.name,  c.phone,  c.adress, c.email, c.total_many  from discounts d join clients c on c.discount = d.id where name=" + name + " and phone=" + phone + ";");
        Client client = null;
        while (resultSet.next()) {
            client = new Client();
            Discount discount = new Discount();
            discount.setId(resultSet.getInt(1));
            discount.setAccumulateCard(resultSet.getInt(2));
            discount.setNewYearDiscount(resultSet.getInt(3));
            discount.setHappyBirthdayDiscount(resultSet.getInt(4));
            discount.setMarch8Discount(resultSet.getInt(5));
            client.setId(resultSet.getInt(6));
            client.setName(resultSet.getString(7));
            client.setPhone(resultSet.getInt(8));
            client.setAddress(resultSet.getString(9));
            client.setEmail(resultSet.getString(10));
            client.setTotalMany(resultSet.getInt(11));
            client.setDiscount(discount);
//       client.setBirthday(resultSet.get(8));
        }
        return client;
    }

    public void createClient(String name, int phone, String adress, String email, int discount, int total_many) throws SQLException {
        Connection connection = PostgresConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into clients (name,  phone,  adress, email,   discount,  total_many) VALUES(" + name + "," + phone + "," + adress + "," + email + "," + discount + "," + total_many + ");";
        statement.executeUpdate(sql);
    }
}
