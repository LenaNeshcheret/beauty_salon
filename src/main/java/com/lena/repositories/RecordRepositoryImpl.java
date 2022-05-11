package com.lena.repositories;

import com.lena.PostgresConnection;
import com.lena.exceptions.BusyTimeRecordException;
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
            "r.id, r.date, c.id " +
            "from records r " +
            "join clients c on r.client_id=c.id join discounts cd on c.discount = cd.id  " +
            "join masters m on r.master_id=m.id join  discounts md on m.discount = md.id";

    @Override
    public List<Record> getRecords(LocalDateTime date) throws SQLException {
        String sql = String.format(SELECT_ALL_RECORDS + " where %s ='%s';", "date", date);
        return getRecords(sql);
    }

    @Override
    public Record getRecords(int recordId) throws SQLException {
        String sql = SELECT_ALL_RECORDS + " where r.id =" + recordId + ";";
        return getRecords(sql).get(0);

    }

    @Override
    public List<Record> getRecords(String startDateTime, String endDateTime) throws SQLException {
        String sql = SELECT_ALL_RECORDS + " where date BETWEEN '" + startDateTime + "' AND '" + endDateTime + "';";
        return getRecords(sql);
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
    public Record createRecord(Record record) throws BusyTimeRecordException {
        Connection connection = PostgresConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT  INTO records (date, client_id, master_id) VALUES('" +
                    record.getDate() + "'," + record.getClient().getId() + "," + record.getMaster().getId() + ");";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new BusyTimeRecordException("Duplicate record on the same time and master", e);
        }
        return null;
    }


    @Override
    public boolean cancelRecord(int recordId) {
        Connection connection = PostgresConnection.getConnection();
        Statement statement = null;
        int result;
        try {
            statement = connection.createStatement();
            String sql = "DELETE from records  where id =" + recordId + ";";
            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            //todo
            e.printStackTrace();
            return false;
        }
        return result == 1;
    }

    private List<Record> getRecords(String sql) throws SQLException {
        Connection connection = PostgresConnection.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        List<Record> records = new ArrayList<>();
        while (resultSet.next()) {
            Record record = parseResultSetToRecord(resultSet);
            records.add(record);
        }
        return records;
    }

    private Record parseResultSetToRecord(ResultSet resultSet) throws SQLException {

        Discount clientDiscount = new Discount();
        clientDiscount.setId(resultSet.getInt(1));
        clientDiscount.setAccumulateCard(resultSet.getInt(2));
        clientDiscount.setNewYearDiscount(resultSet.getInt(3));
        clientDiscount.setHappyBirthdayDiscount(resultSet.getInt(4));
        clientDiscount.setMarch8Discount(resultSet.getInt(5));
        Client client = new Client.Builder()
                .withId(resultSet.getInt(25))
                .withName(resultSet.getString(6))
                .withPhone(resultSet.getInt(7))
                .withAddress(resultSet.getString(8))
                .withEmail(resultSet.getString(9))
                .withDiscount(clientDiscount)
                .build();
        Master master = new Master();
        Discount masterDiscount = new Discount();
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
        master.setRating(resultSet.getBigDecimal(22));
        master.setDiscount(masterDiscount);
        Record record = new Record();
        record.setId(resultSet.getInt(23));
        record.setDate(resultSet.getTimestamp(24).toLocalDateTime());
        record.setClient(client);
        record.setMaster(master);
        return record;
    }
}
