package org.jfbarahonag;

import org.jfbarahonag.database.DatabaseConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbConnection = new DatabaseConnection();

        try (Connection conn = dbConnection.getConnection()) {

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
