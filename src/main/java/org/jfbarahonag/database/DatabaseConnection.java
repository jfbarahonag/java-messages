package org.jfbarahonag.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    Connection connection = null;

    String engine = "mysql";
    String host = "localhost:3306";
    String database = "messages_app";
    String url = "jdbc:"+engine+"://"+host+"/"+database;
    String user = "admin";
    String password = ".admin123";

    /**
     * Singleton of the database
     * @return connection
     */
    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                throw new RuntimeException("Connection with database failed");
            }
        }
        return connection;
    }
}
