import java.util.Scanner;


public class PadStringHelper {

    public static void padString() {
        // retrieve input from the user; the length and a string
        String word = getInputString();
        int length = getInputLength();


        /* using a if statement */
        // if the input length is greater than the word's length
        // if (length > word.length()) {

        //     // find out how many dashes/hyphens will need to pad a sentence
        //     int totalDashes = length - word.length();
        //     for (int dash = 0; dash < totalDashes; dash++) {
        //         word = "-" + word;
        //     }
        // }

        /* not using an if statement */
        int totalDashes = length - word.length();
        for (int dash = 0; dash < totalDashes; dash++) {
            word = "-" + word;
        }

        // print the word
        System.out.println(word);
    }

    public static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        
        // prompt the user for a string
        System.out.print("Please enter a string: ");

        // store input in a var
        String stringInput = scanner.next();
        
        // there is also the nextLine? method, or something along those lines

        // return the variable that is stored
        return stringInput;
    }
    public static int getInputLength() {
        Scanner scanner = new Scanner(System.in);

        // prompt the user for a length
        System.out.print("Please enter the length of the result string: ");

        // store input in a var
        int stringLength = scanner.nextInt();

        return stringLength;
    }
}
