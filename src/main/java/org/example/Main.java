package org.example;

import java.sql.*;


public class Main {
    public static void main(String[] args) {
        Client client = new Client("John Doe", 500.0);
        Staff staff1 = new Staff("Alice Johnson", "Waiter", 15.0);
        Staff staff2 = new Staff("Bob Smith", "Chef", 20.0);

        staff1.addHoursWorked(40);
        staff2.addHoursWorked(45);

        staff1.paySalary();
        staff2.paySalary();

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "3789";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            addClientToDatabase(connection, client);
            bookTheRoom(connection, client);
            addStaffToDatabase(connection, staff1);
            addStaffToDatabase(connection, staff2);



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Adds a client to the database
    public static void addClientToDatabase(Connection connection, Client client) throws SQLException {
        String sql = "INSERT INTO clients (name, money) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, client.getName());
            statement.setDouble(2, client.getMoney());
            statement.executeUpdate();
            System.out.println("Client added to the database: " + client.getName());
        }
    }
    // Adds a staff to the database
    public static void addStaffToDatabase(Connection connection, Staff staff) throws SQLException {
        String sql = "INSERT INTO staff (name, position) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, staff.getName());
            statement.setString(2, staff.getPosition());
            statement.executeUpdate();
            System.out.println("Staff added to the database: " + staff.getName());
        }
    }
    // Books a room for a client
    public static void bookTheRoom(Connection connection, Client client) throws SQLException {
        Room[] allRooms = Room.getAllRooms();
        String sql = "UPDATE room SET booked=? WHERE price=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, client.getName());
            statement.setInt(2, client.chooseRoom(allRooms).getPrice());
            statement.executeUpdate();
            System.out.println("Room booked for client: " + client.getName());
        }
    }
    // Updates client's information in the database
    public static void updateClientInDatabase(Connection connection, Client client, double newMoney) throws SQLException {
        String sql = "UPDATE clients SET money=? WHERE name=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, newMoney);
            statement.setString(2, client.getName());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Client updated in the database: " + client.getName());
            } else {
                System.out.println("Failed to update client in the database: " + client.getName());
            }
        }
    }
    // Deletes a staff member from the database
    public static void deleteStaffFromDatabase(Connection connection, Staff staff) throws SQLException {
        String sql = "DELETE FROM staff WHERE name=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, staff.getName());
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Staff deleted from the database: " + staff.getName());
            } else {
                System.out.println("Failed to delete staff from the database: " + staff.getName());
            }
        }
    }
    // Deletes a client from the database
    public static void deleteClientFromDatabase(Connection connection, Client client) throws SQLException {
        String sql = "DELETE FROM clients WHERE name=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, client.getName());
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Client deleted from the database: " + client.getName());
            } else {
                System.out.println("Failed to delete client from the database: " + client.getName());
            }
        }
    }
}
