package org.example;
public class Staff extends Person {
    private String position;
    private int hourlyRate;
    private int hoursWorked;

    public Staff(String name, String position, int hourlyRate) {
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


    public int paySalary() {
        int salary = this.hourlyRate * this.hoursWorked;
        System.out.println(this.getName() + " earned a salary of: $" + salary);
        this.hoursWorked = 0;
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Position: " + position + ", Hourly Rate: $" + hourlyRate + ", Hours Worked: " + hoursWorked;
    }
}
