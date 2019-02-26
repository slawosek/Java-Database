package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String USERNAME = "YourUsername";
    private static final String PASSWORD = "YourPassword";
    private static final String CONN = "jdbc:mysql://localhost/school?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONN,USERNAME,PASSWORD);

    }
}
