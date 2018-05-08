package com.mhf.interfaces.scripts.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDatabase {

    public static Connection getConn() throws SQLException {

        Connection conn = null;
        try {
            String dbURL = "jdbc:oracle:thin:@10.184.57.4:1521/orq1083a.int.thomsonreuters.com";
            Properties properties = new Properties();
            properties.put("user", "OGT_FTA_MX_AB");
            properties.put("password", "OGT_FTA_MX_AB");
            // properties.put("defaultRowPrefetch", "20");
            conn = DriverManager.getConnection(dbURL, properties);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

        return conn;
    }
}
