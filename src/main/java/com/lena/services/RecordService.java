package com.lena.services;

import com.lena.exceptions.BusyTimeRecordException;
import com.lena.repositories.Record;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public interface RecordService {

    List<Record> getRecord(LocalDateTime date) throws SQLException;

    Record getRecord(int recordId) throws SQLException;

    List<Record> getRecords(String startDateTime, String endDateTime)throws SQLException;

    List<LocalDateTime> getAvailableSlotRecords (LocalDateTime startDataTime, LocalDateTime endDateTime);

    Record createRecord(LocalDateTime date, String nameClient, int phoneClient, String nameMaster) throws BusyTimeRecordException;

    boolean cancelRecord(int recordsId);

}