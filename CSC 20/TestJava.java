import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

public class TestJava {

    public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);
		// takeOutMenu();
		System.out.println(sleepIn(false, false));
		System.out.println(sleepIn(true, false));
		System.out.println(sleepIn(false, true));


	}

	public static boolean sleepIn(boolean weekday, boolean vacation) { 
		if (weekday == false || vacation) {
			return true;
		}
		return false;
	}

	// public static double averageScores(double scores) throws FileNotFoundException{
	// 	double average = 0;
	// 	Scanner file = new Scanner(new File("scores.txt"));

	// }














	public static void printMystery(String[] sentence) {
		for (int i=sentence.length-1; i>=0; i--) {
			System.out.println("element[" + i + "] =" + sentence[i]);
		}
	}

	public static void mystery(int x) {
		int y=0;
		while(x%2 ==0) {
			y++;
			x = x/2;
		}
		System.out.println(x + " " + y);
	}

	public static void takeOutMenu() {
		Scanner scan = new Scanner(System.in);
		double subTotal = 0;
		double foodPrice = 0;
		double quantity;
		int menuOptions;
		double total = 0;
		double foodItem = 0;
		boolean ordering = true;
		while(ordering) {
		menu();
		menuOptions = scan.nextInt();
  
  
		   switch(menuOptions) {
			  case 1:
				 foodItem = 1;
				 total += foodPrice(scan, foodItem, subTotal);
				 break;
  
			  case 2:
				 foodItem = 2;
				 total += foodPrice(scan, foodItem, subTotal);
				 break;
  
			  case 3:
				 foodItem = 3;
				 total += foodPrice(scan, foodItem, subTotal);
				 break;
  
			  case 4:
				 done();
				 ordering = false;
				//  total = total  subTotal(quantity(scan, subTotal, foodPrice),foodPrice(scan, foodItem, subTotal));
				 break;
			  default:
				 System.out.println("Not Avaliable.");
			  }
			}
		System.out.println("Total amount: " + total);
		
  
	 }
	 
	 public static void menu(){
		System.out.println("Welcome \n1. Burger ($2.00) \n2. Fries ($1.50) \n3. Soda($1.00) \n4. Done");
	 }
  
	 public static double foodPrice(Scanner scan, double foodItem, double subTotal) {
	 double foodPrice = 0;
		if(foodItem == 1) {
		   System.out.println("You've ordered a burger");
		   foodPrice = 2.00;
		}
		if(foodItem == 2) {
		   System.out.println("You've ordered fries");
		   foodPrice = 1.50;
		}
		if(foodItem == 3) {
		   System.out.println("You've ordered a soda");
		   foodPrice = 1.00;
		}
		foodPrice = quantity(scan, subTotal, foodPrice);
		return foodPrice;
	 }
  public static double quantity(Scanner scan, double subTotal, double foodPrice) {
		System.out.println("Enter quantity");
		double quantity = scan.nextDouble();
		quantity = subTotal(quantity, foodPrice);
  
		return quantity;
	 }
	 public static double subTotal(double quantity, double foodPrice) {
		double subTotal = quantity * foodPrice;
		System.out.println("Subtotal: " +subTotal);
  
		return subTotal;
	 }
	 public static void done() {
		System.out.println("Enjoy your meal");
	 }
  }
