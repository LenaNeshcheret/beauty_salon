package com.lena.services;

import com.lena.repositories.Record;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;


public interface RecordRepository {

    Record getRecords(LocalDateTime date) throws SQLException;

    List<Record> getMasterRecords (int masterId) throws SQLException;

    List<Record> getRecordClient(int clientId)throws SQLException;


    void createRecord(LocalDateTime date);

    List<Record> getRecords(String startDateTime, String endDateTime) throws SQLException;
//    Client getClient(String name, int phone) throws SQLException;
//
//    void createClient(String name, int phone, String adress, String email, int discount, int total_many) throws SQLException;
}
