package com.lena;

import com.lena.repositories.Record;
import com.lena.repositories.RecordRepositoryImpl;
import com.lena.services.RecordServiceImpl;

import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) throws Exception {
//        ClientService clientService = new ClientServiceImpl();
////        clientService.createClient("'Tonya'",  055550111, "'Kiev, st. Dobr, 15'", "'tonya@gmail.com'", 1,100);
//
//        Client client= clientService.findClient("'Tonya'", 055550111);
//        System.out.println(client);


//        MasterServiceImpl masterService = new MasterServiceImpl();
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
        LocalDateTime startDataTime = LocalDateTime.of(2022, 1, 9, 8, 0, 0);
        LocalDateTime endDataTime = LocalDateTime.of(2022, 1, 10, 12, 0, 0);
        new RecordServiceImpl().schedule(startDataTime, endDataTime);
    }

}


