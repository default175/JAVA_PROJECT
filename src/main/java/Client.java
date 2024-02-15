package org.example;

import java.util.Scanner;



public class Client extends Person {
    Scanner sc = new Scanner(System.in);

    private double money;
    private Room room;

    public Client(String name, double money) {
        super(name);
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public Room chooseRoom(Room[] rooms) {
        int cnt = 1;
        System.out.println(this.getName() + "please choose room type:");

        int choice;

        do {
            // Выводим элементы массива
            System.out.println("Rooms:");
            for (int i = 0; i < rooms.length; i++) {
                System.out.println((i + 1) + ": " + rooms[i]);
            }

            // Запрашиваем выбор пользователя
            System.out.print("Choose room:");
            choice = sc.nextInt();

            if (choice > 0 && choice <= rooms.length && money>=rooms[choice-1].getPrice()) {
                System.out.println(this.getName()+" choose room: " + rooms[choice - 1]);
                return rooms[choice - 1];
            } else if (choice != 0 && choice>rooms.length) {
                System.out.println("There is no such room");
                return null;
            }

            System.out.println(this.getName() + " doesn't have enough money for this room. Choose other room or enter '0' to exit");
        } while (choice != 0);


        System.out.println(this.getName() + " doesn't have enough money for any room.");






        return null;
    }

    @Override
    public String toString() {
        if (this.room != null) {
            return super.toString() + ", Booked Room: " + room + ", Remaining Money: " + money;
        } else {
            return super.toString() + ", No Room Booked, Money: " + money;
        }
    }
}