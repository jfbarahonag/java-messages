package org.jfbarahonag.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    String engine = "mysql";
    String host = "localhost:3306";
    String database = "messages_app";
    String url = "jdbc:"+engine+"://"+host+"/"+database;
    public Connection getConnection() {
        try(Connection connection = DriverManager.getConnection(url,"admin",".admin123")){
            if (connection == null) throw new RuntimeException("Connection not established");
            System.out.println("Connection established");
            return connection;
        } catch (SQLException e) {
            System.out.println("Error getting connection from " + url);
            throw new RuntimeException(e);
        }
    }
}
