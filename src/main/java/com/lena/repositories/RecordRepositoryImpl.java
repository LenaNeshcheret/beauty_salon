package com.lena.repositories;

import com.lena.PostgresConnection;
import com.lena.services.RecordRepository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RecordRepositoryImpl implements RecordRepository {

    public static final String SELECT_ALL_RECORDS = "select " +
            "cd.id, cd.discount_card, cd.new_year, cd. birth, cd.march_8, " +
            "c.name, c.phone, c.adress, c.email, " +
            "md.id, md.discount_card, md.new_year, md.birth, md.march_8, " +
            "m.id, m.name, m.phone, m.adress, m.email, m.profession, m.payment, m.rating, " +
            "r.id, r.date " +
            "from records r " +
            "join clients c on r.client_id=c.id join discounts cd on c.discount = cd.id  " +
            "join masters m on r.master_id=m.id join  discounts md on m.discount = md.id";

    public Record getRecords(LocalDateTime date) throws SQLException {
        Connection connection = PostgresConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = SELECT_ALL_RECORDS + " where date ='" + date + "';";

        ResultSet resultSet = statement.executeQuery(sql);
        Record record = null;
        while (resultSet.next()) {
            record = parseResultSetToRecord(resultSet);
        }
        return record;
    }

    @Override
    public List<Record> getMasterRecords(int masterId) throws SQLException {
        return null;
    }

    @Override
    public List<Record> getRecordClient(int clientId) throws SQLException {
        return null;
    }

    @Override
    public void createRecord(LocalDateTime date) {

    }

    @Override
    public List<Record> getRecords(String startDateTime, String endDateTime)throws SQLException {
        Connection connection = PostgresConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = SELECT_ALL_RECORDS + " where date BETWEEN '" + startDateTime + "' AND '" + endDateTime + "';";

        ResultSet resultSet = statement.executeQuery(sql);
        List<Record> recordList = new ArrayList<>();
        while (resultSet.next()) {
            Record record = parseResultSetToRecord(resultSet);
            recordList.add(record);
        }
        return recordList;

    }

    private Record parseResultSetToRecord(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        Discount clientDiscount = new Discount();
        clientDiscount.setId(resultSet.getInt(1));
        clientDiscount.setAccumulateCard(resultSet.getInt(2));
        clientDiscount.setNewYearDiscount(resultSet.getInt(3));
        clientDiscount.setHappyBirthdayDiscount(resultSet.getInt(4));
        clientDiscount.setMarch8Discount(resultSet.getInt(5));
        client.setName(resultSet.getString(6));
        client.setPhone(resultSet.getInt(7));
        client.setAddress(resultSet.getString(8));
        client.setEmail(resultSet.getString(9));
        client.setDiscount(clientDiscount);
        Master master = new Master();
        Discount masterDiscount =new Discount();
        masterDiscount.setId(resultSet.getInt(10));
        masterDiscount.setAccumulateCard(resultSet.getInt(11));
        masterDiscount.setNewYearDiscount(resultSet.getInt(12));
        masterDiscount.setHappyBirthdayDiscount(resultSet.getInt(13));
        masterDiscount.setMarch8Discount(resultSet.getInt(14));
        master.setId(resultSet.getInt(15));
        master.setName(resultSet.getString(16));
        master.setPhone(resultSet.getInt(17));
        master.setAddress(resultSet.getString(18));
        master.setEmail(resultSet.getString(19));
        master.setProfession(resultSet.getString(20));
        master.setPayment(resultSet.getInt(21));
        master.setRating(resultSet.getInt(22));
        master.setDiscount(masterDiscount);
        Record record = new Record();
        record.setId(resultSet.getInt(23));
        record.setDate(resultSet.getTimestamp(24).toLocalDateTime());
        record.setClient(client);
        record.setMaster(master);
        return record;
    }
}
