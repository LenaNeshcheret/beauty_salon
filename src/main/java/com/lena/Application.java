package com.lena;

import com.lena.repositories.Client;
import com.lena.repositories.Master;
import com.lena.repositories.RecordRepositoryImpl;
import com.lena.services.ClientService;
import com.lena.services.ClientServiceImpl;
import com.lena.services.MasterServiceImpl;
import com.lena.services.RecordServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

public class Application {
    public static void main(String[] args) throws Exception {
        System.out.println(args.length);
//        ClientService clientService = new ClientServiceImpl();
//////        clientService.createClient("'Tonya'",  055550111, "'Kiev, st. Dobr, 15'", "'tonya@gmail.com'", 1,100);
////
//        Client client= clientService.findClientByNameAndPhone("'Ivanka'", 501232233);
//        System.out.println(client);
//
//
//        MasterServiceImpl masterService = new MasterServiceImpl();
//        Master master= masterService.findMaster("'Katya'");
//        System.out.println(master);
//        masterService.createMaster("'Sasha'", 2222222, "'Kiev, st. Vern, 5'",
//                "'sasha@gmail.com'", 2, "'hairdresser'", 500,4);

//        Master master = masterService.findMaster("'Sasha'",2222222);
//        System.out.println(master);
//        LocalDateTime date = LocalDateTime.now();
//        Timestamp timestamp = Timestamp.valueOf("2022-01-10 10:00:00");
//        LocalDateTime localDateTime = timestamp.toLocalDateTime();
//        System.out.println(localDateTime);


//        LocalDateTime of = LocalDateTime.of(2022, 1, 10, 10, 0, 0);
//        System.out.println( "1111" +of);
//        Record record = new RecordRepositoryImpl().getRecords(of);
//        System.out.println(record);
//        LocalDateTime startDataTime = LocalDateTime.of(2022, 1, 10, 10, 0, 0);
//        LocalDateTime endDataTime = LocalDateTime.of(2022, 1, 10, 16, 0, 0);
//        List<LocalDateTime> timeSlots = new RecordServiceImpl().getTimeSlots(startDataTime, endDataTime);
//        System.out.println("All slots");
//        System.out.println(timeSlots.toString());
//        System.out.println("Records slots");
//        new RecordServiceImpl().getRecords(startDataTime.toString(),endDataTime.toString()).forEach(r -> System.out.println(r.getDate()));
//        System.out.println("Free slots");
//        List<LocalDateTime> availableSlotRecords = new RecordServiceImpl().getAvailableSlotRecords(startDataTime, endDataTime);
//        System.out.println(availableSlotRecords);
    }

}


