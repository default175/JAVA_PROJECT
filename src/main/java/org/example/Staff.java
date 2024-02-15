package org.example;
public class Staff extends Person {
    private String position;
    private double hourlyRate;
    private int hoursWorked;

    public Staff(String name, String position, double hourlyRate) {
        super(name);
        this.position = position;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0;
    }

    public String getPosition() {

        return position;
    }

    public void addHoursWorked(int hours) {
        this.hoursWorked += hours;
        System.out.println(this.getName() + " has now worked " + this.hoursWorked + " hours.");
    }


    public void paySalary() {
        double salary = hourlyRate * hoursWorked;
        System.out.println(this.getName() + " earned a salary of: $" + salary);
        hoursWorked = 0; // Сброс количества отработанных часов
    }

    @Override
    public String toString() {
        return super.toString() + ", Position: " + position + ", Hourly Rate: $" + hourlyRate + ", Hours Worked: " + hoursWorked;
    }
}
