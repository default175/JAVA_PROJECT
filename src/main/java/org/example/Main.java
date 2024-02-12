package org.example;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("John Doe", 500.0);
        Staff staff1 = new Staff("Alice Johnson", "Waiter");
        Staff staff2 = new Staff("Bob Smith", "Chef");

        Room[] allRooms = Room.getAllRooms();
        client.chooseRoom(allRooms);

        System.out.println(staff1);
        System.out.println(staff2);
    }
}