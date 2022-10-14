package com.lena.exceptions;

import java.sql.SQLException;

public class BusyTimeRecordException extends Exception {
    public BusyTimeRecordException(String s, SQLException e) {
        super(s, e);
    }
}
