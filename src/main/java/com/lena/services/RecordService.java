package com.lena.services;

import com.lena.repositories.Record;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public interface RecordService {

    public Record getRecord(LocalDateTime date) throws SQLException;

    List<Record> getRecords(String startDateTime, String endDateTime)throws SQLException;
}
