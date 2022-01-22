package com.lena.services;

import com.lena.repositories.Record;
import com.lena.repositories.RecordRepositoryImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class RecordServiceImpl implements RecordService {
    RecordRepository recordRepository = new RecordRepositoryImpl();


    @Override
    public Record getRecord(LocalDateTime date) throws SQLException {

        Record record = recordRepository.getRecords(date);
        return record;
    }

    @Override
    public List<Record> getRecords(String startDateTime, String endDateTime) throws SQLException {
        List<Record> records = recordRepository.getRecords(startDateTime, endDateTime);
        records.forEach(i -> System.out.println(i));
        return records;
    }

    //    @Override
    public List<Record> getMasterRecords(int masterId) throws SQLException {
        return null;
    }

    //    @Override
    public List<Record> getRecordClient(int clientId) throws SQLException {
        return null;
    }

    //    @Override
    public void createRecord(LocalDateTime date) {

    }

    public List<LocalDateTime> schedule(LocalDateTime startDataTime, LocalDateTime endDataTime) {
        LocalTime startHour = LocalTime.of(7, 0, 0);
        LocalTime endHour = LocalTime.of(20, 0, 0);
        List<LocalDateTime> listSchedule = new ArrayList<>();

//        for (LocalDateTime currentDate = startDataTime; currentDate.isBefore(endDataTime); currentDate=currentDate.plusDays(1))
//            for (LocalDateTime currentTime = currentDate; currentTime.isBefore(endDataTime); currentTime=currentTime.plusHours(1)) {
//               listSchedule.add(currentTime);
//
//            }

        for(LocalDateTime currentDateTime = startDataTime; currentDateTime.isBefore(endDataTime); currentDateTime=currentDateTime.plusHours(1)){
            LocalTime currentTime = currentDateTime.toLocalTime();
            if(currentTime.isAfter(startHour )&& currentTime.isBefore(endHour)){

            }
        }
    }
}
