import java.util.*;
import java.io.*;

public class PersonalityTestHelper {

    public static final int PERSONALITY_TYPES = 4;
    public static final int TOTAL_PARTICIPANTS = 9;
    public static final int QUESTION_GROUPS = 7;

    public static void personalityTest() 
            throws FileNotFoundException{

        Scanner scan = new Scanner(new File("personality.txt"));
        // while file has text, it has pairs.
        while (scan.hasNextLine()) { 
            String name = scan.nextLine(); 
            String answers = scan.nextLine().toLowerCase();


            // method to count the number of each character that could be present
            // which can be used in further calculations

            // these arrays return an array of size 4, and checks if the specific character "a", "b", or "-" is in the 
            // respectfed question it refers to, 1, 2 3 4 5 6 or 7. 
            int[] charACount = countCharacterA(answers);
            // example return ^: [4, 9, 9, 9] the number of As for each question in its respected category; i used modulo in these methods
            int[] charBCount = countCharacterB(answers);
            int[] dashCount = countCharacterDash(answers);

            // test to figure out the percentages
            // a for loop that checks the percentages, also returns an array of size 4, but this array contains the percentage
            // to each category, so [85, 60, 15, 15] is an example
            int[] percentages = returnPercentages(charACount, charBCount, dashCount);
            System.out.print(name + " : ");

            // method to run the percentages returned and get a personality for the user
            String userPersonality = getUserPersonality(percentages);

            System.out.print(Arrays.toString(percentages) + " = ");
            System.out.println(userPersonality);

            

        }
    }

    // A method to compute the count of A and B responses for a single user
    public static int[] countCharacterB(String test) {
        int[] totalB = new int[PERSONALITY_TYPES];

        // loop through text and find b's
        for (int i=0; i<test.length(); i++) {
            // check the char
            if (Character.toLowerCase(test.charAt(i)) == 'b') {
                // check the index if the character was b
                switch(i % QUESTION_GROUPS) {
                    case 0:
                        totalB[0]++;
                        break;
                    case 1:
                    case 2:
                        totalB[1]++;
                        break;
                    case 3:
                    case 4:
                        totalB[2]++;
                        break;
                    case 5:
                    case 6:
                        totalB[3]++;
                        break;
                }
            }
        }

        return totalB;
    }
    // A method to compute the count of A and B responses for a single user
    public static int[] countCharacterA(String test) {
        int[] totalA = new int[PERSONALITY_TYPES];

        // loop through text and find b's
        for (int i=0; i<test.length(); i++) {
            // check the char
            if (Character.toLowerCase(test.charAt(i)) == 'a') {
                // check the index if the character was b
                switch(i % QUESTION_GROUPS) {
                    case 0:
                        totalA[0]++;
                        break;
                    case 1:
                    case 2:
                        totalA[1]++;
                        break;
                    case 3:
                    case 4:
                        totalA[2]++;
                        break;
                    case 5:
                    case 6:
                        totalA[3]++;
                        break;
                }
            }
        }

        return totalA;
    }

    // A method to compute the count of A and B responses for a single user

    public static int[] countCharacterDash(String test) {
        int[] totalDash = new int[PERSONALITY_TYPES];

        // loop through text and find b's
        for (int i=0; i<test.length(); i++) {
            // check the char
            if (Character.toLowerCase(test.charAt(i)) == '-') {
                // check the index if the character was b
                switch(i % QUESTION_GROUPS) {
                    case 0:
                        totalDash[0]++;
                        break;
                    case 1:
                    case 2:
                        totalDash[1]++;
                        break;
                    case 3:
                    case 4:
                        totalDash[2]++;
                        break;
                    case 5:
                    case 6:
                        totalDash[3]++;
                        break;
                }
            }
        }

        return totalDash;
    }


    // A method to determine the final personality type for a single user
    public static int[] returnPercentages(int[] totalA, int[] totalB, int[] totalDash) {
        int[] personalityPercentages = new int[PERSONALITY_TYPES];
        for (int i=0; i<4; i++) {
            // get the percentage into an int
            double percent =  (((double)totalB[i] / (totalA[i] + totalB[i])) * 100);
            // personalityPercentages[i] = (int) (((double)totalB[i] / (totalA[i] + totalB[i])) * 100);

            // have to typecase it here for some reason if not java gives error. 
            personalityPercentages[i] = (int)Math.round(percent);
        }

        return personalityPercentages;
    }

    public static String getUserPersonality(int[] percentages) {
        String userPersonality = "";
        for (int i =0; i< 4; i++) {
            double percent = percentages[i];
            
            // determine the personality group
            if (i == 0) {
                if (percent == 50) {
                    userPersonality += "X";
                } else if (percent > 50) {
                    userPersonality += "I";
                } else {
                    userPersonality += "E";
                }
            } else if (i == 1) {
                if (percent == 50) {
                    userPersonality += "X";
                } else if (percent > 50) {
                    userPersonality += "N";
                } else {
                    userPersonality += "S";
                }
            } else if (i == 2) {
                if (percent == 50) {
                    userPersonality += "X";
                } else if (percent > 50) {
                    userPersonality += "F";
                } else {
                    userPersonality += "T";
                }
            } else if (i == 3) {
                if (percent == 50) {
                    userPersonality += "X";
                } else if (percent > 50) {
                    userPersonality += "P";
                } else {
                    userPersonality += "J";
                }
            }
        }

        return userPersonality;
    }

}
