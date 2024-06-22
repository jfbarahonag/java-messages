package org.jfbarahonag.service;

import org.jfbarahonag.dao.MessageDAO;
import org.jfbarahonag.model.Message;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MessageService {
    MessageDAO dao = new MessageDAO();

    public void create() {
        Scanner sc = new Scanner(System.in);
        String inputMessage = "";
        String inputAuthor = "";
        String messageToUser = "Write your message";

        System.out.println(messageToUser);
        inputMessage = sc.nextLine().trim();

        messageToUser = "Write the name of the author";
        System.out.println(messageToUser);
        inputAuthor = sc.nextLine().trim();

        Message newMsg = new Message(inputAuthor, inputMessage);
        dao.insertMessage(newMsg);
    }

    public void getAll() {
        List<Message> messages = dao.getAllMessages();
        messages.forEach(System.out::println);
    }

    public void delete() {
        Scanner sc = new Scanner(System.in);
        String messageToUser = "Write the id of the message to be deleted";
        System.out.println(messageToUser);

        try {
            int id = sc.nextInt();
            if (id < 1) {
                System.out.println("Negative IDs are invalid");
                return;
            }
            boolean done = dao.deleteMessage(id);
            String message = done ? "Message deleted successfully" : "Error deleting message " + id;
            System.out.println(message);
        } catch (InputMismatchException e) {
            System.out.println("Invalid id type");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public void update() {

    }
}
