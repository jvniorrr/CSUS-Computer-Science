public class CoinConvertLastHelper {
    
    /* 
     * Function: coinsConvert
     * 
     * Simulates the action of a Coinstar machine that turns coins into cash
     * Converts quarters, dimes, nickels, and pennies to a dollar
     * value with a 10% fee reduction.
    */
    public static void coinsConvert() {
        //Run #1
        // System.out.println("Run #1: ");
        int quarters = 200, dimes = 20, nickels = 44, pennies = 100;

        //Run #2
        // System.out.println("Run #2: ");
        // int quarters = 350, dimes = 45, nickels = 55, pennies = 200;

        // retrieve total amount of cents
        double quartersValue = quarters * 25.0;
        double dimesValue = dimes * 10.0;
        double nickelsValue = nickels * 5.0;
        double totalCents = quartersValue + dimesValue + nickelsValue + (double)pennies; // pennyValue
        // double totalCents = (quarters * 25.0) + (dimes * 10.0) + (nickels * 5.0) + (double)pennies; 

        // print the run and the total cents
        System.out.printf("%d quarters, %d dimes, %d nickels, %d pennies, is equal to %.1f cents.%n", 
                        quarters, dimes, nickels, pennies, totalCents);

        // retrieve the fee price, and display in dollar amount || calculate 10% of total Value
        double feesTotal = Math.round(totalCents * .1);

        // retrieve fee values
        int newVal = (int) feesTotal;
        int pennyFees= (newVal % 100);
        int dollarFees = (newVal / 100);

        // calculate the 10% fee
        System.out.printf("The fee you will pay is: %d dollars and %d cents.%n", dollarFees, pennyFees);        

        // subtract fee cost from total
        int returnTotal = (int) (totalCents - feesTotal);

        // calculate the total amount after fees || convert pennies to dollars and cents
        int dollarsReturned = (int) returnTotal / 100;
        int penniesReturned = (int) returnTotal % 100;
        System.out.printf("You should get %d$ and %d cents.%n", dollarsReturned, penniesReturned);
    }
}
