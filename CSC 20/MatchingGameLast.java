/*
Name: First Last
Self-Grade: 100
Date Program Created: 02/06/22
*/


// import Scanner and Random objects
import java.util.*;

public class MatchingGameLast {
    public static void main(String[] args) {
        // create Scanner obj & Random obj
        Scanner kb = new Scanner(System.in);

        Random rand = new Random();
        
        // declare a string variable and assign "" to it call this variable answer
        String answer = "";

        while (!answer.equalsIgnoreCase("q")) {
            // call the description method 
            description();
            // prompt the user to enter their name, store their name in a variable
            System.out.print("\nWhat is your name: ");
            String playerName = kb.nextLine();
            
            // display the hello message
            System.out.printf("\nHello %s lets start playing\n", playerName);

            // call the play method and pass the RAndom object that you created to it
            play(rand);

            // display  the message "Hit enter to let another person play or enter Q to quit the program"
            System.out.print("\nHit enter to let another person play or enter Q to quit the program: ");

            // store the user's input in the answer variable.
            answer = kb.nextLine();
        }

        // display a good bye message
        System.out.println("Good Bye! Come back soon to play again");

    }

    /*
        Method which return a random number between 1 and 9 inclusively
    */
    public static int getRand(Random rand) {
        // return a number > 0
        return rand.nextInt(9) + 1;
    }

    /*
        Method to play a single game (should be used within a loop)
    */
    public static void play(Random rand) {
        Scanner kb = new Scanner(System.in);

        int total = 0;

        String answer = "";
        int n1=0, n2=0, n3=0;
        
        // call the method getRand(rand) 3 times and store the result in the vars n1,n2,n3
        while (!answer.equalsIgnoreCase("q")) {
            n1 = getRand(rand);
            n2 = getRand(rand);
            n3 = getRand(rand);
            // display the generated numbers

            int match = match(n1, n2, n3);

            if (match == 2) {
                // add 100 to the total
                total  += 100;
                // display proper message
                System.out.println("You got two matches, you won 100 dollars");
            }
            else if (match == 3) {
                // add  300 to the total
                total += 300;

                // display proper message
                System.out.println("You got three matches, you won 300 dollars");
            } 
            else {
                // display proper message
                System.out.println("Sorry no match");

            }

            System.out.print("\nHit enter to continue or press q/Q to quit ");
            answer = kb.nextLine();
        }

        System.out.printf("\nTotal amount you won: %d\n\n", total);
    }

    public static int match(int n1, int n2, int n3) {
        System.out.printf("\nYou got: %d %d %d\n", n1, n2, n3);

        if (n1 == n2 && n2 == n3) {
            return 3;
        }
        else if (n1 == n2 || n1 == n3 || n2 == n3) {
            return 2;
        }
        else {
            return 0;
        }
    }

    public static void description() {
        // print first two lines of stars
        System.out.println("\n*********************************************************************************************");
        System.out.println("* Welcome to number matching game. I will generate three random numbersfor you. If two      *");
        System.out.println("* of the numbers match you win 100, if you get three matching numbers you win 300 dollars   *");
        System.out.println("*********************************************************************************************");
    }
}
