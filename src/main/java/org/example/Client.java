package org.example;

public class Client extends Person {
    private double money;
    private Room room;

    public Client(String name, double money) {
        super(name);
        this.money = money;
    }


    public void chooseRoom(Room[] rooms) {
        for (Room room : rooms) {
            if (this.money >= room.getPrice()) {
                this.room = room;
                this.money -= room.getPrice();
                System.out.println(this.getName() + " has booked " + room + ". Remaining money: " + this.money);
                return;
            }
        }
        System.out.println(this.getName() + " doesn't have enough money for any room.");
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
