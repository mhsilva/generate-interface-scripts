package com.mhf.interfaces.scripts.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDatabase {

    public static Connection getConn() throws SQLException { 

        Connection conn = null;
        try {
            String dbURL = "jdbc:oracle:thin:@URL:1521/SERVICE_NAME";
            Properties properties = new Properties();
            properties.put("user", "USER");
            properties.put("password", "PASS");
            // properties.put("defaultRowPrefetch", "20");
            conn = DriverManager.getConnection(dbURL, properties);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

        return conn;
    }
}
