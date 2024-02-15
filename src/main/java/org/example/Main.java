package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {


        Client client = new Client("John Doe", 500.0);
        Client client2 = new Client("Maks Erlin", 600.0);
        Staff staff1 = new Staff("Alice Johnson", "Waiter");
        Staff staff2 = new Staff("Bob Smith", "Chef");

        Room[] allRooms = Room.getAllRooms();
        client.chooseRoom(allRooms);
        client2.chooseRoom(allRooms);

        System.out.println(staff1);
        System.out.println(staff2);



        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "olzhas06";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);


            addClientToDatabase(connection, client);
            addClientToDatabase(connection, client2);

            addStaffToDatabase(connection, staff1);
            addStaffToDatabase(connection, staff2);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addClientToDatabase(Connection connection, Client client) throws SQLException {
        String sql = "INSERT INTO clients (name, money) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, client.getName());
        statement.setDouble(2, client.getMoney());
        statement.executeUpdate();
        System.out.println("Client added to the database: " + client.getName());
    }

    public static void addStaffToDatabase(Connection connection, Staff staff) throws SQLException {
        String sql = "INSERT INTO staff (name, position) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, staff.getName());
        statement.setString(2, staff.getPosition());
        statement.executeUpdate();
        System.out.println("Staff added to the database: " + staff.getName());
    }
}
