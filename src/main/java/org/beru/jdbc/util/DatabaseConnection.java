package org.beru.jdbc.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String url = "jdbc:mysql://192.168.0.100:3306/test";
    private static String name = "beru";
    private static String password = "Giobero140206MYSQL";

    private static BasicDataSource pool;

    public static BasicDataSource getInstance() {
        if(pool == null) {
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(name);
            pool.setPassword(password);

            pool.setInitialSize(3);
            pool.setMinIdle(3);
            pool.setMaxIdle(15);
            pool.setMaxTotal(10);
        }
        return pool;
    }

    public static Connection getConnection(){
        try {
            return getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
