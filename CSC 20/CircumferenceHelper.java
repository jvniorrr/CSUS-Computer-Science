import java.util.Scanner; // Scanner object
import java.lang.Math; // Math module

public class CircumferenceHelper {
    /*
    Java program called Circumference that takes two set of coodinates on the XY Cartesian plane and calculates the distance between these two points. 
    It then uses this distance as a radius to calculate the circumference of a circle that has this radius.
    */
    
    // method that prompts user for 3 cartesian coordinates, and prints the circumference and radius between 2 set of points.
    public static void calculateThreeCircumferences() {
        // create a for loop to prompt the user for Cartesian coordinates 3 times.
        for (int i=0; i<3; i++){
            calculateCircumference();
        }
    }

    public static void calculateCircumference() {
        // create a scanner obj
        Scanner scanner = new Scanner(System.in);

        // retrieve the first set of coordinate points
        System.out.print("Please enter integer input for Point 1: x1 ");
        int x1 = scanner.nextInt();
        System.out.print("Please enter integer input for Point 1: y1 ");
        int y1 = scanner.nextInt();

        // retrieve the second set of coordinate points
        System.out.print("Please enter integer input for Point 2: x2 ");
        int x2 = scanner.nextInt();
        System.out.print("Please enter integer input for Point 2: y2 ");
        int y2 = scanner.nextInt();

        // calculate the distance between the 2 points
        double radius = calculateRadius(x1, y1, x2, y2);

        // calculate the circumference of the circle
        double circumference = computeCircumference(radius);

        // print the radius and circumference which was calculated
        System.out.printf("Radius = %.2f\nCircumference = %.2f\n", radius, circumference);

    }

    // calculateDistance method; calculates distance between points
    public static double calculateRadius(int x1, int y1, int x2, int y2) {
        double radius = Math.sqrt( (double) (Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2)) );
        return radius;
    }

    // compute circumference of 2 point values and returns value
    public static double computeCircumference(double radius) {
        return (double) (2 * Math.PI * radius);
    }
}
