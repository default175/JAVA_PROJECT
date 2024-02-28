package org.example;
import lombok.*;

@Getter @Setter
public class Staff extends Person implements User {
    private String position;
    private double hourlyRate;
    private int hoursWorked;

    public Staff(String name, String position, double hourlyRate) {
        super(name);
        this.position = position;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0;
    }

    public void addHoursWorked(int hours) {
        this.hoursWorked += hours;
        System.out.println(this.getName() + " has now worked " + this.hoursWorked + " hours.");
    }

    public double paySalary() {
        double salary = hourlyRate * hoursWorked;
        System.out.println(this.getName() + " earned a salary of: $" + salary);
        hoursWorked = 0; // Resetting the number of hours worked
        return salary;
    }




    @Override
    public String toString() {
        return super.toString() + ", Position: " + position + ", Hourly Rate: $" + hourlyRate + ", Hours Worked: " + hoursWorked;
    }

    @Override
    public double getMoney() {

        return 0.0;
    }

    @Override
    public void setMoney(double amount) {

    }

    @Override
    public void addMoney(double amount) {

    }

    @Override
    public void deductMoney(double amount) {

    }
}
