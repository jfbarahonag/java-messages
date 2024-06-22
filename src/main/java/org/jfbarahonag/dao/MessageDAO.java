package org.jfbarahonag.dao;

import org.jfbarahonag.database.DatabaseConnection;
import org.jfbarahonag.model.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    }

    private static Message getMessage(ResultSet rs) throws SQLException {
        Message message = new Message();
        message.setId_message(rs.getInt("id_message"));
        message.setAuthor(rs.getString("author"));
        message.setMessage(rs.getString("message"));
        message.setDate(rs.getString("date"));
        return message;
    }

    public void insertMessage(Message message) {
        String sqlQuery = "INSERT INTO messages (message, author) VALUES (?,?)";
        try(Connection c = getConnection();
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
            System.out.println(e.getMessage());
        }
    }

    public List<Message> getAllMessages() {
        String query = "SELECT id_message, message, author, date FROM messages";
        List<Message> messages = new ArrayList<>();
        try(Connection c = getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(query);
        ) {
            while (rs.next()) {
                Message message = getMessage(rs);
                messages.add(message);
            }
            return messages;
        } catch (SQLException e) {
            System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " fail");
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public void deleteMessage(int id) {

    }

    public void updateMessage(int id, Message newMessage) {

    }
}
