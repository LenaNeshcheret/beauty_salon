package com.lena.services;

import com.lena.exceptions.BusyTimeRecordException;
import com.lena.repositories.Client;
import com.lena.repositories.Master;
import com.lena.repositories.Record;
import com.lena.repositories.RecordRepositoryImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class RecordServiceImpl implements RecordService {
    RecordRepository recordRepository = new RecordRepositoryImpl();

    @Override
    public List<Record> getRecord(LocalDateTime date) throws SQLException {
        return recordRepository.getRecords(date);
    }

    @Override
    public Record getRecord(int recordId) throws SQLException {
        Record record = recordRepository.getRecords(recordId);
        return record;
    }

    @Override
    public List<Record> getRecords(String startDateTime, String endDateTime) throws SQLException {
        List<Record> records = recordRepository.getRecords(startDateTime, endDateTime);
//        records.forEach(i -> System.out.println(i));
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

    @Override
    public Record createRecord(LocalDateTime date, String nameClient, int phoneClient, String nameMaster) throws BusyTimeRecordException {

        ClientServiceImpl clientService = new ClientServiceImpl();
        Client client = clientService.findClientByNameAndPhone(nameClient, phoneClient);
        MasterServiceImpl masterService = new MasterServiceImpl();
        Master master = masterService.findMaster(nameMaster);
        Record record = new Record(date, client, master);
        recordRepository.createRecord(record);
        return record;
    }

    @Override
    public boolean cancelRecord(int recordsId) {
        return recordRepository.cancelRecord(recordsId);
    }


    public List<LocalDateTime> getTimeSlots(LocalDateTime startDataTime, LocalDateTime endDataTime) {
        LocalTime startHour = LocalTime.of(7, 0, 0);
        LocalTime endHour = LocalTime.of(20, 0, 0);
        List<LocalDateTime> listTimeSlots = new ArrayList<>();
        LocalTime startDataNew = LocalTime.of(startDataTime.getHour(), 0, 0);
        LocalDateTime startDataTimeNew = LocalDateTime.of(startDataTime.getYear(), startDataTime.getMonth(), startDataTime.getDayOfMonth(),
                startDataTime.getHour(), startDataNew.getMinute(), startDataNew.getSecond());



        for (LocalDateTime currentDateTime = startDataTimeNew; currentDateTime.isBefore(endDataTime); currentDateTime = currentDateTime.plusHours(1)) {
            LocalTime currentTime = currentDateTime.toLocalTime();
            if (currentTime.isAfter(startHour) && currentTime.isBefore(endHour)) {
                listTimeSlots.add(currentDateTime);
            }
        }
        return listTimeSlots;
    }


    public List<LocalDateTime> getAvailableSlotRecords(LocalDateTime startDataTime, LocalDateTime endDateTime) {
        //get all time slots

        List<LocalDateTime> listAllTimeSlots = getTimeSlots(startDataTime, endDateTime);
        //get busy slot
        List<Record> records = null;
        try {
            records = getRecords(startDataTime.toString(), endDateTime.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // get free = oll-busy
        List<LocalDateTime> listFreeTimeSlot = new ArrayList<>();
        for (int i = 0; i < records.size(); i++) {
            LocalDateTime busyTimeSlot = records.get(i).getDate();
            listAllTimeSlots.remove(busyTimeSlot);
        }
        return listAllTimeSlots;
    }
}
