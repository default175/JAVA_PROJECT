package org.example;

public class Room {
    public enum Type {
        ECONOMY, STANDARD, ENHANCED_STANDARD, JUNIOR_SUITE, SUITE
    }

    public enum BedType {
        SINGLE, DOUBLE
    }

    private Type type;
    private BedType bedType;
    private double price;

    public Room(Type type, BedType bedType, double price) {
        this.type = type;
        this.bedType = bedType;
        this.price = price;
    }



    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Room Type: " + type + ", Bed Type: " + bedType + ", Price: " + price;
    }


    public static Room[] getAllRooms() {
        return new Room[]{
                new Room(Type.ECONOMY, BedType.SINGLE, 50),
                new Room(Type.ECONOMY, BedType.DOUBLE, 70),
                new Room(Type.STANDARD, BedType.SINGLE, 100),
                new Room(Type.STANDARD, BedType.DOUBLE, 120),
                new Room(Type.ENHANCED_STANDARD, BedType.SINGLE, 150),
                new Room(Type.ENHANCED_STANDARD, BedType.DOUBLE, 170),
                new Room(Type.JUNIOR_SUITE, BedType.SINGLE, 200),
                new Room(Type.JUNIOR_SUITE, BedType.DOUBLE, 220),
                new Room(Type.SUITE, BedType.SINGLE, 300),
                new Room(Type.SUITE, BedType.DOUBLE, 350)
        };
    }
}
