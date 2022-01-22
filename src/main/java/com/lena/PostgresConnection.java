package com.lena;

import java.sql.*;

public class PostgresConnection {

    public static Connection getConnection(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/beauty_salon","postgres","TestUser1!");
            return connection;
        }
       catch (Exception e){
           System.out.println("Error ");
       }
        return null;
    }
}
