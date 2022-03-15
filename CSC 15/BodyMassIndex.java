import java.util.*;

public class BodyMassIndex {
    public static void main(String[] args) {
        // create scanner object
        Scanner scan = new Scanner(System.in);

        // read users height in inches
        System.out.print("Height (in inches): ");
        double userHeight = scan.nextDouble();

        // read users weight in lbs
        System.out.print("Weight (in pounds): ");
        double weight = scan.nextDouble();

        double BMI = 703 * weight / Math.pow(userHeight, 2);
        System.out.println(BMI);


    }
}
