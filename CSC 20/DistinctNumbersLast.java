/*
Name: First Last
Self-Grade: Sophomore?
Date Program Created: 1/31/22
*/


// import modules for Scanner
import java.util.*;

public class DistinctNumbersLast {
    public static void main(String[] args) {
        System.out.println("Welcome to the distinct numbers.\nI will remove the repeated numbers and display the numbers you just entered.");
    
        // declare an array of integers w/ size 10
        int[] numbers = new int[10];

        // call method getInput that returns an array and store in variable created
        numbers = getInput();

        // call the method display and pass the arrays of numbers to it. 
        display(numbers);
    }


    // method to find if a specific number `n` is found within an array; returns true if true.
    public static boolean found(int[] num, int n) {
        // loop through the list and check if the specific number is found
        for(int numElement : num) {
            if (numElement == n) {
                return true;
            }
        }
        // if that specific # is not found just return false 
        return false;
    }

    // method that gets input from user and stores that input in an array
    public static int[] getInput() {
        // declare an array of integers w/ the size 10
        int[] numbers = new int[10];

        // create a Scanner object
        Scanner scan = new Scanner(System.in);

        // create a for loop that loops from 0 to one less than the size of the array
        for (int i=0; i<numbers.length; i++) {
            // prompt the user to enter an integer number and store that number into a variable
            System.out.print("Enter a number: ");
            int userNumber = scan.nextInt();

            // call method found and store inside a boolean variable
            boolean numberFound = found(numbers, userNumber);

            // if true (number is not distinct; # is already stored) -> decrement the loop control variable
            if (numberFound == true) {
                i--;
            } 
            // if false (number is distinct) then store the users input in the array    
            else {
                numbers[i] = userNumber;
            }
        }
        return numbers;
    }

    // method that uses for loop to display content of the array
    public static void display(int[] num) {
        System.out.println("I filtered out all the repeated numbers you entered and kept only one copy of each number\nHere is the list of your numbers");
        // fencepost
        System.out.printf("{%d", num[0]);
        // for loop that goes form 0 to num.length-1
        for (int i=1; i<=num.length-1;i++) {
            System.out.printf(", %d", num[i]);
        }
        System.out.println("}");
    }


}
