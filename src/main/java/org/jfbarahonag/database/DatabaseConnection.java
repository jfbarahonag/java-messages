package org.jfbarahonag.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String engine = "mysql";
    private static final String host = "localhost:3306";
    private static final String database = "messages_app";
    private static final String url = "jdbc:"+engine+"://"+host+"/"+database;
    private static final String user = "admin";
    private static final String password = ".admin123";

    /**
     * Singleton of the database
     * @return connection
     */
    public static Connection getInstance() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
