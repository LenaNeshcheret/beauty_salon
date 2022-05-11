package com.lena.repositories;

import com.lena.PostgresConnection;
import com.lena.services.ClientRepository;

import java.sql.*;


public class ClientRepositoryImpl implements ClientRepository {

    public Client findClientByNameAndPhone(String name, int phone) throws SQLException {
        try (Connection connection = PostgresConnection.getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select d.id, d.discount_card, d.new_year, d. birth, d.march_8," +
                    " c.id, c.name,  c.phone,  c.adress, c.email, c.total_many  from discounts d " +
                    "join clients c on c.discount = d.id where name='" + name + "' and phone=" + phone + ";");
            Client client = null;
            while (resultSet.next()) {
                Discount discount = new Discount();
                discount.setId(resultSet.getInt(1));
                discount.setAccumulateCard(resultSet.getInt(2));
                discount.setNewYearDiscount(resultSet.getInt(3));
                discount.setHappyBirthdayDiscount(resultSet.getInt(4));
                discount.setMarch8Discount(resultSet.getInt(5));
                client = new Client.Builder()
                        .withId(resultSet.getInt(6))
                        .withName(resultSet.getString(7))
                        .withPhone(resultSet.getInt(8))
                        .withAddress(resultSet.getString(9))
                        .withEmail(resultSet.getString(10))
                        .withTotalMany(resultSet.getInt(11))
                        .withDiscount(discount)
                        .build();
            }
            statement.close();
            connection.close();
            return client;
        }
    }

    public void createClient(String name, int phone, String adress, String email, int discount, int total_many) throws SQLException {
        Connection connection = PostgresConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into clients (name,  phone,  adress, email,   discount,  total_many) VALUES(" + name + "," + phone + "," + adress + "," + email + "," + discount + "," + total_many + ");";
        statement.executeUpdate(sql);
    }

    @Override
    public Client findClientByLoginAndPassword(String login, String password) throws SQLException {
        Connection connection = PostgresConnection.getConnection();
        String sql = "select c.id, c.name, c.phone, c.adress, c.email, c.total_many, c.discount from discounts d " +
                " join clients c on c.discount = d.id where login=? and password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        Client client = null;
        while (resultSet.next()) {
            Discount discount =new Discount();
            discount.setId(resultSet.getInt(7));
            client = new Client.Builder()
                    .withId(resultSet.getInt(1))
                    .withName(resultSet.getString(2))
                    .withPhone(resultSet.getInt(3))
                    .withAddress(resultSet.getString(4))
                    .withEmail(resultSet.getString(5))
                    .withTotalMany(resultSet.getInt(6))
                    .withDiscount(discount)
                    .build();
        }
        return client;
        }
    }
