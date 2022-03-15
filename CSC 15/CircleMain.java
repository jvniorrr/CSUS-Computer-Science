import java.util.Arrays;
/*
Name: First Last
Date: 12-10-21
Programming Assignment: Lab 7
*/

public class CircleMain {
  	public static void main(String[] args) {
		// Declare a circle called circleOne using the default constructor   
		Circle circleOne = new Circle();
		// Declare a circle called circleTwo using the regular constructor
		Circle circleTwo = new Circle(-5, -6, 9);
		
		// call getters for both circles & display x, y, and radius
		System.out.printf("Circle One (x,y, radius): (%d,%d, %d)\n", circleOne.getX(), circleOne.getY(), circleOne.getRadius());
		System.out.printf("Circle Two (x,y, radius): (%d,%d, %d)\n", circleTwo.getX(), circleTwo.getY(), circleTwo.getRadius());

		// call the getArea method for both circles and display the areas
		System.out.printf("Circle One (Area): %f\n", circleOne.getArea());
		System.out.printf("Circle Two (Area): %f\n", circleTwo.getArea());

		// call the getCircumference method for both circles and display the circumference
		System.out.printf("Circle One (Circumference): %f\n", circleOne.getCircumference());
		System.out.printf("Circle Two (Circumference): %f\n", circleTwo.getCircumference());

		// change the center of circleOne to (4,5) using setter methods
		circleOne.setX(4);
		circleOne.setY(5);

		// change the radius of circleTwo to 11 using the setter method 
		circleTwo.setRadius(11);

		// display both circles using toString method

		System.out.printf("Circle One: %s\n", circleOne.toString());
		System.out.printf("Circle Two: %s\n", circleTwo.toString());
		

		// create an array of circle class object using toString method
		Circle[] circArray = new Circle[2];
		circArray[0] = circleOne;
		circArray[1] = circleTwo;
		System.out.println(Arrays.toString(circArray));
  	}  
}
