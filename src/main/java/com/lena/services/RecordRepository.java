package com.lena.services;

import com.lena.exceptions.BusyTimeRecordException;
import com.lena.repositories.Record;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;


public interface RecordRepository {

    List<Record> getRecords(LocalDateTime date) throws SQLException;

    Record getRecords(int recordId) throws SQLException;

    List<Record> getMasterRecords (int masterId) throws SQLException;

    List<Record> getRecordClient(int clientId)throws SQLException;

    Record createRecord(Record record) throws BusyTimeRecordException;

    List<Record> getRecords(String startDateTime, String endDateTime) throws SQLException;

    boolean cancelRecord(int recordsId);

//    Client findClientByNameAndPhone(String name, int phone) throws SQLException;
//
//    void createClient(String name, int phone, String adress, String email, int discount, int total_many) throws SQLException;
}
