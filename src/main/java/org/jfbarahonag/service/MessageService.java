package org.jfbarahonag.service;

import org.jfbarahonag.dao.MessageDAO;
import org.jfbarahonag.model.Message;

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

    public void delete(int id) {

    }

    public void update(int id, Message newMessage) {

    }
}
