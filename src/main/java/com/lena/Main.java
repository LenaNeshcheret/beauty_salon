//package com.lena;
//
//import com.lena.services.ClientService;
//import com.lena.services.ClientServiceImpl;
//
//import java.sql.*;
//
//
//public class Main {
//    public static void main(String[] args) throws Exception {
//        ClientService clientService = new ClientServiceImpl();
//        Class.forName("org.postgresql.Driver");
//        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/beauty_salon","postgres","TestUser1!");
//        Statement statement = connection.createStatement();
//
//        // try to pass insert query
//
////        boolean execute = statement.execute();
////        statement.getResultSet();
//
////        ResultSet resultSet1 = statement.executeQuery();
////
//        ResultSet resultSet = statement.executeQuery("select  phone from clients");
//        while (resultSet.next()) {
//            String string = resultSet.getString(1);
//
//            System.out.println(string);
//
//
//        }
//        int  str= statement.executeUpdate("update clients set phone=111 where id=2");
//        System.out.println("get update"+"  "+statement.getUpdateCount());
//        System.out.println("result set"+"  "+statement.getResultSet());
//
//
//        System.out.println(str);
////        UPDATE Laptop
////        SET hd = ram/2 WHERE hd < 10;
//
//
//        ResultSet updatedResultSet = statement.executeQuery("select  phone from clients");
//        while (updatedResultSet.next()) {
//            String string = updatedResultSet.getString(1);
//
//            System.out.println(string);
//
//
//        }
//
////                resultSet.getString();
////        resultSet;
//        connection.close();
//    }
//}
