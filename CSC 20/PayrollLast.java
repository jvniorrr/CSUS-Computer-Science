/*
Name: First Last
Self-Grade: 100
Date Program Created: 02/14/22
*/

class Payroll {
    // instance variables
    private String name, id;
    private double hourlyRate, HoursWorked;


    // constructors
    public Payroll(String name, String id, double HourlyRate, double hoursWorked) {
        this.name = name;
        this.id = id;
        this.hourlyRate = HourlyRate;
        this.HoursWorked = hoursWorked;
    }
    public Payroll() {
        this.name = "";
        this.id = "";
        this.hourlyRate = 0;
        this.HoursWorked = 0;
    }

    /*
    GETTER METHODS 
    */
    
    // return the name of the person
    public String getName(){
        // perhaps capitalize
        return this.name;
    }

    // return the id of the person
    public String getId() {
        return this.id;
    }

    // return the hourly rate of the person
    public double getHourlyRate() {
        return this.hourlyRate;
    }

    // return the number of hours worked
    public double getHoursWorked() {
        return this.HoursWorked;
    }


    /*
    SETTER/MUTATOR METHODS
    */

    // changes the name of the person to the given parameter
    public void setName(String name) {
        this.name = name;
    }

    // changes the hourly rate to the given parameter
    public void setHourlyRate(double rate) {
        this.hourlyRate = rate;
    }
    
    // changes the hours worked to the given parameter
    public void setHoursWorked(double hours) {
        this.HoursWorked = hours;
    }

    // calculates the amount that the person is getting paid. 
    public double getPay() {
        return this.hourlyRate * this.HoursWorked;
    }

    /*
    TO STRING METHOD 
    */
    // returns a string representing the attributes for the given person. Should return a string in given format. 
    public String toString() {
        String s1 = String.format("Name: %s\nID: %s\nHours Worked: %.1f\nHourly Rate: %.1f", 
                                    this.name, this.id, this.HoursWorked, this.hourlyRate
                                );
        return s1;
    }


}

public class PayrollMendoza {
    public static void main(String[] args) {
        /* uncomment  the provided code below */
        System.out.println("Creating payroll objects");
        Payroll p1 = new Payroll("Alex Martinez" ,"123456", 25, 20);
        Payroll p2 = new Payroll("Ali Santos" ,"986747", 125, 45);
        Payroll p3 = new Payroll(" Jose Busta" ,"45678", 55, 30);
        System.out.println("testing the toString method");
        System.out.println("List of the employees");
        System.out.println(p1);
        System.out.println("Salary is : " + p1.getPay());  //calling the getPay method
        System.out.println("\n*******************");
        System.out.println(p2);
        System.out.println("Salary is : "+ p2.getPay());
        System.out.println("\n*******************");
        System.out.println(p3);
        System.out.println("Salary is : "+ p3.getPay());
        System.out.println("\n*******************");
        System.out.println("\nTesting the setter methods");
        System.out.println("The hourly pay of " + p1.getName()  + " is being changed");
        p1.setHoursWorked(80);  // changing the hours worked for the object p1
        System.out.println(p1);            
        /**/


        //***********************************************************************************
    
    
        /*        Your turn , you need to implement code for each commnet  below       
        */
        
        //1. create two objects of the payroll class 
        Payroll obj1 = new Payroll("First Last", "990212", 20, 45);
        Payroll obj2 = new Payroll("Please Work", "001001", 30, 25);

        //2. display the objects on the screen by calling the toString method
        //2. display the salary of each person by calling the getPay method
        System.out.println("\n*******************");
        System.out.println(obj1);
        System.out.println("Salary is : "+ obj1.getPay());
        System.out.println("\n*******************");
        System.out.println(obj2);
        System.out.println("Salary is : "+ obj2.getPay());

        //change the hourlyRate of the objects you created
        System.out.println("\n*******************");
        System.out.println("Changing the salary on both objects that were created");
        obj1.setHourlyRate(20);
        obj2.setHourlyRate(35);

        //display the objects again to see the changes you made by calling the toString method
        System.out.println("\n*******************");
        System.out.println(obj1);
        System.out.println("\n*******************");
        System.out.println(obj2);


        //change the hoursworked for the objects you created by calling the setter methods
        System.out.println("\n*******************");
        System.out.println("Changing the hours worked for the objects created");
        obj1.setHoursWorked(50);
        obj2.setHoursWorked(35);

        //display your objects again to see the changes you made
        System.out.println("\n*******************");
        System.out.println(obj1);
        System.out.println("\n*******************");
        System.out.println(obj2);

        //add any other code you want

    }
}
