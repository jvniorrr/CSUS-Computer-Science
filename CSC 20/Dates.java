/*
Description: Determines if date entered by user is 2nd-millenium date
Name: First Last
Class: CSC 15
Assignment: Lab 7
*/

import java.util.Scanner;


public class Dates {
    public static void main(String[] args) {
        int month, day, year;
        // month=2;
        // day=28;
        // year=1021;

        //number of days in month read in boolean monthValid, yearValid, dayValid; 
        boolean monthValid=false, yearValid=false, dayValid=false, isLeapYear=false;

        // prompt the user for the month day and year
        System.out.println("Enter month, day and year");

        //date read in from user int daysInMonth; 
        // int daysInMonth;
        Scanner scanner = new Scanner(System.in);

        month = scanner.nextInt();
        day = scanner.nextInt();
        year = scanner.nextInt();

        
        // check if valid month
        if (month >= 1 && month <= 12) {
            monthValid = true;

            // check the year that was entered and see if leap year
            if (year >= 1000 && year <= 1999) {

                yearValid = true;

                // check other months, and assign dayValid to true if within the range of that month
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    // if the days is within 1 and 31
                    if (day >= 1 && day <= 31) {
                        dayValid = true;
                    } else {
                        dayValid = false;
                    }
                } 
                else if (month == 2) {
                    if (day >= 1 && day <= 28) {
                        dayValid = true;
                    } else {
                        dayValid = false;
                    }
                }
                // if it does not fall in to the if block above, the month is still within range 1-12 so set days valid if < 30
                else {
                    if (day >= 1 && day <= 30) {
                        dayValid = true;
                    } else {
                        dayValid = false;
                    }
                }

                // check here if leap year
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    // this is a leap year
                    isLeapYear = true;
                    
                    // check if the month is february
                    if (month == 2) {
                        // total days can be up to 29
                        if ((day >= 1 && day <= 29)) {
                            dayValid = true;
                        } else {
                            dayValid = false;
                        }
                    }
                }
            } else {
                yearValid = false;
            }

        } else {
            monthValid = false;
        }


        // check if it is valid year
        // if (year >= 1000 && year <= 1999) {
        //     yearValid = true;
        // }

        
        //true if input from user is valid boolean leapYear; 
        
        //true if user's year is a leap year Scanner scan = new Scanner(System.in); 
        
        //Get integer month, day, and year from user 
        
        //Check to see if month is valid  [HINT: month >= 1 && month <= 12]
        
        //Check to see if year is valid [HINT: yearValid = year >= 1000 && year <= 1999]
        
        //Determine whether it's a leap year 
        
        //Determine number of days in month 
        
        //User number of days in month to check to see if day is valid [HINT: dayValid = day <= daysInMonth]
        
        //Determine whether date is valid and print appropriate message Using the below lines of code, 

        if (dayValid && monthValid && yearValid) {
            System.out.println("Date is valid");

            if (isLeapYear) {
                System.out.println("year is a leap year");
            }
        } else {
            System.out.println("Date is invalid");
        }
        
    }
}
