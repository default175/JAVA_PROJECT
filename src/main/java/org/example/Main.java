package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


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

        try {
            Connection connection = DriverManager.getConnection(url, username, password);


            addClientToDatabase(connection, client);
            bookTheRoom(connection,client);

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

    public static void bookTheRoom(Connection connection, Client client) throws SQLException{
        Room[] allRooms = Room.getAllRooms();
        String sql = "update room set booked=? where price=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, client.getName());
        statement.setInt(2, Integer.parseInt(Integer.toString(client.chooseRoom(allRooms).getPrice())));
        statement.executeUpdate();
    }

}
