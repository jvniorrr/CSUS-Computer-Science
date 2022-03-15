/*
Name: First Last
Lab Date: 11/21/2021
AAssignment Name: Programming Assignment 5
*/


// import packages
import java.util.*;


public class GuessingGameHelper {

    // create constants to store games and guesses
    public static int TOTAL_GAMES = 0;
    public static int BEST_GAME;
    // theoretically, the most guesses out of a range 1-100 is 100.
    // but since we assume that no game will require one million or more guesses
    public static int BEST_GAME_GUESSES=1000000;
    public static final int MAXIMUM = 100;

    // main method to have the game running while the user wants to play
    public static void runGame() {
        // create my objects to use throughout program
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.printf("I'm thinking of number between 1 and " + MAXIMUM + "...\n");
        
        // boolean to run game
        boolean gameIsLive = true;

        // store the total guesses
        int totalGuesses =0;
        // store the total games played
        int totalCurrentGames = 0;

        // run while loop to play number of guessing games
        while (gameIsLive) {
            // create a random number for the gam
            int randNumber = rand.nextInt(MAXIMUM) + 1;
            // System.out.println(randNumber);

            // play the game
            int gameGuesses = playGame(scan, randNumber);
            totalGuesses += gameGuesses;
            totalCurrentGames++;

            // check the number of guesses returned from playGame and reference best game var
            if (gameGuesses <= BEST_GAME_GUESSES) {
                //
                BEST_GAME_GUESSES = gameGuesses;
                BEST_GAME = totalCurrentGames;
            }
            
            // prompt user if want to play again
            gameIsLive = getAnswer(scan);
        }

        printStatistics(totalCurrentGames, totalGuesses);
    }

    // looping game method, rerun the game
    public static int playGame(Scanner scan,int randNumber) {
        boolean guessIncorrect = true;
        int userGuess, totalGuesses =0;


        while (guessIncorrect) {
            // ask user for input
            System.out.printf("Your guess? ");
            // retrieve user input
            userGuess = scan.nextInt();
            // add to totalGuesses
            totalGuesses++;
            if (userGuess == randNumber) {
                if (totalGuesses == 1) {
                    System.out.printf("You got it right in %d guess!\n", totalGuesses);
                } else {
                    System.out.printf("You got it right in %d guesses!\n", totalGuesses);
                }
                guessIncorrect = false;
            } else if (userGuess < randNumber) {
                System.out.printf("It's higher.\n");
            } else if (userGuess > randNumber) {
                System.out.printf("It's lower.\n");
            }   
        }

        return totalGuesses;
    }

    
    // method that returns boolean, checking if user wants to continue playing
    public static boolean getAnswer(Scanner scan) {
        // ask for user input
        System.out.print("Do you want to play again? ");

        // retrieve user input
        String playString = scan.next();

        // parse the string to see if first char is a y
        char checkChar = Character.toLowerCase(playString.charAt(0));

        // if its anything with a y at beginning return true
        if (checkChar == 'y') {
            // continue game
            return true;
        } else {
            return false;
        }

    }

    // method to print the stats of the game; best games and guesses
    public static void printStatistics(int numOfGames, int totalGuesses) {
        System.out.print("\nOverall results:");
        System.out.print("\nTotal Games = " + numOfGames);
        System.out.print("\nTotal guesses = " + totalGuesses);

        // format the output for guess/game
        // double guessPerGame = Math.round( ( 10.0 * ((double)(totalGuesses) / numOfGames) ) ) / 10.0;
        System.out.print("\nGuesses/game = " + (double)Math.round( ( 10.0 * ((double)(totalGuesses) / numOfGames) ) ) / 10.0);
        // System.out.printf("\nGuesses/game = %f", (double)Math.round( ( 10.0 * ((double)(totalGuesses) / numOfGames) ) ) / 10.0);
        System.out.print("\nBest Game = " + BEST_GAME);
    }
}
