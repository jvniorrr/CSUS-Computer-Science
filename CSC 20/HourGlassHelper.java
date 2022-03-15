public class HourGlassHelper {
    // RUN #1 (draw a hourglass of size 14, 2 times)
    public static final int HOURGLASS_SIZE = 14;
    public static final int HOURGLASS_TIMES = 2;

    // RUN #2 (draw a hourglass of size 6, 5 times)
    // public static final int HOURGLASS_SIZE = 6;
    // public static final int HOURGLASS_TIMES = 5;


    // method to draw the hour glass
    public static void drawHourGlass() {
        // print the single line
        drawLine();

        // loop to print the hour glass X amount of times
        for (int i=0; i < HOURGLASS_TIMES; i++) {
            drawTop();
            drawBottom();
        }

        // print the single line
        drawLine();
    }

    // method to draw a single line with dashes and a plus character
    public static void drawLine() {
        // print the single plus character
        System.out.print("+");

        // print the dashes 
        for (int i=0; i < HOURGLASS_SIZE; i++) {
            System.out.print("-");
        }

        // print the single plus character
        System.out.println("+");
    }

    // method to draw the top part of the hourglass
    public static void drawTop() {
        // the amount of lines upward or downward is half the size length
        int columnLines = HOURGLASS_SIZE / 2;

        // loop through the total lines and print the periods
        for (int i=1; i <= columnLines; i++) {
            // printing a line or column here
            System.out.print("|");

            // print the spaces
            for (int j=1; j < i; j++) {
                System.out.print(" ");
            }

            // print the backslash after spaces (left side)
            System.out.print("\\");

            // print the periods
            for (int j=1; j <= HOURGLASS_SIZE - (i * 2); j++) {
                System.out.print(".");
            }

            // print the forward slash (right side)
            System.out.print("/");

            // print the spaces
            for (int j=1; j < i; j++) {
                System.out.print(" ");
            }

            // print the last character of line
            System.out.println("|");
        }
    }

    // method to draw the bottom part of the hourglass
    public static void drawBottom() {
        // the amount of lines upward or downward is half the size length
        int columnLines = HOURGLASS_SIZE / 2;
        
        // do a backward loop to print spaces and backslashes
        for (int i=columnLines; i >= 1; i--) {
            // printing a line or column here
            System.out.print("|");

            // print the spaces
            for (int j=1; j < i; j++) {
                System.out.print(" ");
            }

            // print the forward slash (left side)
            System.out.print("/");

            // print the periods
            for (int j=1; j <= HOURGLASS_SIZE - (i * 2); j++) {
                System.out.print(".");
            }

            // print the backslash (right side)
            System.out.print("\\");

            // print the spaces
            for (int j=1; j < i; j++) {
                System.out.print(" ");
            }
            
            // print the last character of line
            System.out.println("|");

        }
    }
}
