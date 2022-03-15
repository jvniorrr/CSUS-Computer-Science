import java.util.*;

public class TakeOutHelper {
    public static void takeOutMenu() {
        // create a scanner object
        Scanner scan = new Scanner(System.in);

        // store the total price
        double total = 0;
        double foodPrice = 0;
        
        // var to store users input
        int userChoice = 0;
        int userQuantity;


        // fencepost algo
        displayMenu();
        userChoice = getUserChoice(scan);
        

        // check if user input
        while (userChoice != 4) {
            // double foodPrice;

            // check for the food choice and set price
            if (userChoice == 1) {
                System.out.println("You've ordered a burger");
                foodPrice = 2;
            } else if (userChoice == 2) {
                System.out.println("You've ordered fries");
                foodPrice = 1.50;
            } else if (userChoice == 3) {
                System.out.println("You've ordered a burger");
                foodPrice = 1;
            }

            // prompt for quantity
            userQuantity = getUserChoiceQuantity(scan);

            // add the food choice to the total ; subtotal to total
            double subtotal = (foodPrice * userQuantity);
            System.out.printf("Subtotal: %.1f\n", subtotal);
            total += subtotal;

            displayMenu();
            
            userChoice = getUserChoice(scan);
        }

        // print the total price to the user 
        System.out.println("Enjoy your meal");
        System.out.printf("Total amount: %.1f\n", total);
    }

    public static void displayMenu() {
        System.out.println("Welcome\n1. Burger ($2.00)\n2. Fries ($1.50)\n3. Soda ($1.00)\n4. Done");
    }

    public static int getUserChoice(Scanner scan) {
        return scan.nextInt();
    }
    public static int getUserChoiceQuantity(Scanner scan) {
        System.out.println("Enter quantity");
        return scan.nextInt();
    }

    
}
