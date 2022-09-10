/*
Name: First Last
Self-Grade: 100
    - Formatted accordingly
    - Methods described
    - Vertical Ruler of 100 used

Date Program Created: 02/28/22
*/
import java.util.*;

public class AirplaneLast {
    
}


class Person{
    //implement your code here

    // required attributes of a Person bording the plane
    private String name, lastName;
    private String ticketID;

    // extra attributes
    // private String phone, email;

    // CONSTRUCTOR
    // only things in Person contstructor are first, last and ticketID
    public Person (String name, String last, String ticketID) {
        this.name = name;
        this.lastName = last;
        this.ticketID = ticketID;

        // this.phone = phone;
        // this.email = email;
    }

    // method to set the firts name of the passenger 
    public void setFirst(String name) {
        this.name = name;
    }

    // method to set the last name of the passenger 
    public void setLast(String last) {
        this.lastName = last;
    }

    // method to set the ticket ID of the passenger 
    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }
    
    // method to return the first name of the passenger 
    public String getFirst() {
        return this.name;
    }

    // method to return the last name of the passenger 
    public String getLast() {
        return this.lastName;
    }

    // method to return the ticket ID of the passenger 
    public String getTicketID() {
        return this.ticketID;
    }
    
    // OBJECT REPRESENTATION
    public String toString() {
        return String.format("Name: %s\nLast: %s\nTicketID: %s", this.name, this.lastName, this.ticketID);
    }

    // method to compare objects
    public boolean equals(Person other) {
        return (other.getLast() == this.lastName && other.getFirst() == this.name);
    }

}

class Passenger extends Person {
    //implement your code here
    
    // required attributes of a person bording a plan
    private int seatNumber;
    private String classType;


    // CONSTRUCTOR
    public Passenger(String first, String last, String ticketId, int seatNumber, String classType) {
        super(first, last, ticketId);
        this.seatNumber = seatNumber;
        this.classType = classType;
    }

    // method to set the seat number for a passenger
    public void setSeatNumber(int num) {
        this.seatNumber = num;
    }
    // method to set the seat class type for a passenger
    public void setClass(String classType) {
        this.classType = classType;
    }

    // method to return the class type of the passenger
    public String getClassType() {
        return this.classType;
    }
    // method to return the seat number of the passenger
    public int getSeatNumber() {
        return this.seatNumber;
    }

    // OBJECT REPRESENTATION
    public String toString() {
        return String.format("%s\nSeat number: %d\nClass: %s\n", super.toString(), 
                                this.seatNumber, this.classType);
    }
}


interface list {   
    public boolean add(Object o);
    public Object search(Object o);
    public boolean delete(Object o);
    public void printLast();
    public void takeOff();
}


class Airplane implements list{
    //declare the instance variable
    public static int count=0;
    private Passenger[] plane;
    private boolean takenOff;
    private int planeNum;

    public Airplane(int planeNum) {
        this.planeNum = planeNum;
        this.plane = new Passenger[10];
        this.takenOff = false;
    }

    // method to get the plane number
    public int getPlaneNumber() {
        return this.planeNum;
    }
    // method to get the plane number
    public void setPlaneNumber(int num) {
        this.planeNum = num;
    }

    // OBJECT REPRENTATION
    public String toString() {
        String s = "";
        for (int i=0; i<plane.length; i++) {
            // check if the string is empty prior
            if (plane[i] != null) {
                // System.out.println(plane[i]);
                s += plane[i].toString() +"\n";
            }
        }
        return s;
    }

    // return count
    public static int getCount() {
        return count;
    }

    //implement the constructor   
    public boolean add(Object o) {
        //complete this method

        // check if type passenget using `instanceof`
        if (o instanceof Passenger) {
            // o = (Passenger) o; 
            if (!this.takenOff) {
                plane[count] = (Passenger) o;
                count++;
                return true;
            }
        }
        // else we will return false if its not of Passenger type
        return false;
    }

    public Object search (Object o) { 
        boolean b = o instanceof String; 
        if(!b) {
            return "There is no passenger with this name";
        }
        String name = (String)o; 
        for(int i = 0; i < plane.length; i++) {
            if(plane[i]!= null && plane[i].getLast().equalsIgnoreCase(name)) {
                return plane[i];   //returning the found object } 
            }
        }
        // else we will return null
        return "There is no passenger with this name";    //returning null if the object is not found
    }
    
    public boolean delete(Object o) {
        boolean b = o instanceof String; 
        if(!b) {
            return false;
        }
        String name = (String)o; 
        for(int i = 0; i < plane.length; i++) {
            if(plane[i]!= null && plane[i].getLast().equalsIgnoreCase(name)) {
                // System.out.printf("Passenger %s has been removed from the list\n", name);
                plane[i] = null;
                return true;   //returning the found object } 
            }
        }
        // else we will return false
        return false;   //returning false if the object is not found
    }

    public void printLast() {
        //complete this method
        for (int i=0; i<plane.length; i++) {
            // make sure the object is not null
            if (plane[i] != null) {
                System.out.println(plane[i].getLast());
            }
        
        }
    }

    public void takeOff() {
        //complete this method
        this.takenOff = true;
    }
}


class Driver {
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        Airplane plane = new Airplane(20394);
        Passenger p1 = new Passenger("Bobby", "Smith", "123456789", 1, "First class");
        Passenger p2 = new Passenger("Johnny", "Apple", "987654321", 8, "Business class");
        Passenger p3 = new Passenger("Tom", "Jerry", "567123489", 32, "Economy class");
        Passenger p4 = new Passenger("Candy", "Cruz", "982134567", 15, "Premium Economy class");
        Passenger p5 = new Passenger("Kaloti", "Aaron", "762134589", 5, "First class");
        plane.add(p1);
        plane.add(p2);
        plane.add(p3);
        plane.add(p4);
        plane.takeOff();
        plane.add(p5);
        System.out.println("Here is the list of the passengers in this plane" + "\n");
        System.out.println(plane + "\n");
        System.out.println("Testing the printLast method to display the last names");
        plane.printLast(); //prints the last name of the passenger sin the 
        // train
        System.out.println();
        
        System.out.println("Testing the static method getCount");
        System.out.println("This train has " + Airplane.getCount() + " Passengers\n");
        
        System.out.print("Enter the last name of the passenger: ");
        String lastName = in.nextLine();
        System.out.println(plane.search(lastName));
        System.out.println();
        
        System.out.println("Testing the delete method");
        System.out.print("Enter the last name of the passenger: ");
        String last = in.nextLine();
        boolean removed = plane.delete(last);
        if (removed) {
            System.out.println("Passenger " + last + " has been removed from the list\n");
        }
        else {
            System.out.println("Passenger " + last + " was not found in the list.");
        }
        
        System.out.println("Here is the updated list");
        System.out.println(plane);
    }
}
    
/*Cretae your own driver with the list of your passengers*/
/*This part has 10 points*/
class MyDriver
{
    public static void main(String[] args)
    {      
        Scanner in = new Scanner(System.in);
        // create  plane object to store passengers
        Airplane Plane2 = new Airplane(20395);

        // create 5 Passenger objects representing a family
        Passenger dad = new Passenger("Jorge", "Rami", "9780989123", 16, "First Class");
        Passenger mom = new Passenger("Julie", "Flynn", "9780989124", 17, "First Class");
        Passenger brother = new Passenger("Junior", "Dodd", "9780989125", 18, "First Class");
        Passenger sister = new Passenger("Lesly", "Mooney", "9780989126", 19, "First Class");
        Passenger uncle = new Passenger("Ted", "Beck", "9780989127", 20, "Premium Economy Class");

        // add family to the plan list
        Plane2.add(dad);
        Plane2.add(mom);
        Plane2.add(brother);
        Plane2.add(sister);
        Plane2.add(uncle);

        // display the last name of all passengers
        System.out.println("Testing the printLast method to display the last names");
        Plane2.printLast();
        System.out.println();

        // Prompt the user for a last name to search the list of passengers. 
        // If found display their info; use search method
        System.out.print("Enter the last name of the passenger: ");
        String lastName = in.nextLine();
        System.out.println(Plane2.search(lastName));
        System.out.println();

        // prompt the user for a last name to delete it form the list of passengers; call delete method
        System.out.println("Testing the delete method");
        System.out.print("Enter the last name of the passenger: ");
        lastName = in.nextLine();
        boolean removed = Plane2.delete(lastName);
        if (removed) {
            System.out.println("Passenger " + lastName + " has been removed from the list\n");
        }
        else {
            System.out.println("Passenger " + lastName + " was not found in the list.");
        }

        // call the toString method to display the updated list
        System.out.println("Here is the updated list");
        System.out.println(Plane2);

        // have the plane take off
        Plane2.takeOff();
        
        // create a new Passenger and add it to Plane2
        Passenger friend = new Passenger("Jakob", "Ventura", "9780989124", 17, "First Class");

        // add newly made Passenger to the plane or attempt
        Plane2.add(friend);
    }
}