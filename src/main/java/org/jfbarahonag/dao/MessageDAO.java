package org.jfbarahonag.dao;

import org.jfbarahonag.database.DatabaseConnection;
import org.jfbarahonag.model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDAO {

    DatabaseConnection dbConn = new DatabaseConnection();

    public void insertMessage(Message message) {
        String sqlQuery = "INSERT INTO messages (message, author) VALUES (?,?)";
        try(Connection c = dbConn.getConnection();
            PreparedStatement ps = c.prepareStatement(sqlQuery);
        ) {
            ps.setString(1, message.getMessage());
            ps.setString(2, message.getAuthor());
            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " success");
            }
        } catch (SQLException e) {
            System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " fail");
        }
    }

    public void getAllMessages() {

    }

    public void deleteMessage(int id) {

    }

    public void updateMessage(int id, Message newMessage) {

    }
}
