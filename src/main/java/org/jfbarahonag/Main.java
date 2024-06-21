package org.jfbarahonag;

import org.jfbarahonag.dao.MessageDAO;
import org.jfbarahonag.database.DatabaseConnection;
import org.jfbarahonag.model.Message;
import org.jfbarahonag.service.MessageService;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MessageService ms = new MessageService();
        Scanner scanner = new Scanner(System.in);
        enum MenuOption {
            POST,
            GET_ALL,
            EDIT,
            REMOVE,
            EXIT;

            public static MenuOption fromInteger(int x) {
                return switch (x) {
                    case 1 -> POST;
                    case 2 -> GET_ALL;
                    case 3 -> EDIT;
                    case 4 -> REMOVE;
                    case 5 -> EXIT;
                    default -> null;
                };
            }
        };
        MenuOption option = MenuOption.POST;

        do {
            showMenu();
            option = MenuOption.fromInteger(scanner.nextInt());

            switch (option) {
                case POST -> ms.create();
                case GET_ALL -> ms.getAll();
                case EDIT -> ms.update(0, new Message());
                case REMOVE -> ms.delete(0);
                case null -> {
                    System.out.println("Invalid");
                }
                default -> {}
            }
        } while (option != MenuOption.EXIT);


        DatabaseConnection dbConnection = new DatabaseConnection();

        try (Connection conn = dbConnection.getConnection()) {

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void showMenu() {
        System.out.println("--------------------------------");
        System.out.println("----- Messages application -----");
        System.out.println("----- 1. Create a message ------");
        System.out.println("----- 2. List messages ---------");
        System.out.println("----- 3. Edit messages ---------");
        System.out.println("----- 4. Delete messages -------");
        System.out.println("----- 5. Exit ------------------");
    }
}
