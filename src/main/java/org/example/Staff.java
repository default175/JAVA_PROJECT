package org.example;

public class Staff extends Person {
    private String position;

    public Staff(String name, String position) {
        super(name);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return super.toString() + ", Position: " + position;
    }
}
