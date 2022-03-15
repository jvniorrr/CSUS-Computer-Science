/*
Name: First Last
Date: 11/07/2021
Lab Name: Programming Assignment 4
*/

import java.util.*;


public class BudgeterHelper {

    // main method which does all the work, calculating the users profits and budget.
    public static void calculateBudget(Scanner scan) {

        displayOpeningMessage();

        // retrieve the users total income categories
        int incomeCategories = getIncomeCategories(scan);
        
        // loop throught the number of categories they respond with
        double income = getTotalIncome(scan, incomeCategories);
        
        // prompt the user for month
        int month = promptWhichMonth(scan);

        // add checks here for the income tax and bonuses
        if (month  ==  4 || month == 12) {
            // check if month is april or december
            income -= (income * 0.10);
        } else if (month == 10) {
            // check if month is october
            income += (income * 0.05);
        }


        // check what month and how many days correlate to it
        int monthDays = daysInMonth(month);

        // ask the user to enter if month or daily expenses
        int dailyOrMonth = promptDailyOrMonthly(scan);

        // retrieve the total expenses categories
        int expensesCategories = getExpensesCategories(scan);

        // retrieve the users expenses as a double
        double expenses = 0;
        if (dailyOrMonth == 1) {
            expenses = getTotalMonthExpenses(scan, expensesCategories);
        } else if (dailyOrMonth == 2) {
            expenses = getTotalDailyExpenses(scan, expensesCategories, monthDays);
        }

        // check if greater than 200, 200 is spent on mini vacation
        if (month == 6  && income > 2000) { 
            expenses += 200;
        }

        // display the total income and expenses
        displayTotalIncomeAndExpenses(income, expenses, monthDays);

        // calculate the net income as a double
        double netIncome = calculateNetIncome(income, expenses);

        // check if the value is pos or neg then use absolute value of it
        displayOutput(netIncome);


    }

    // Method that just describes the program
    public static void displayOpeningMessage() {
        System.out.println("This program asks for your monthly income and expenses, then tells you your net monthly income.\n");
    }

    /*
    Method that prompts the user for the month expenses / profit they are looking for
    @param      scan            Scanner object
    @returns    int             int value specifying the month number the user is referencing
    */
    public static int getIncomeCategories(Scanner scan) {
        System.out.print("How many categories of income? ");
        return scan.nextInt();
    }


    /*
    Method that prompts the user for the month expenses / profit they are looking for
    @param      scan            Scanner object
    @param      categories      integer value specifying how many incomes the user had / 'categories'
    @returns    double          double value of the total income the user had for a specific month
    */
    public static double getTotalIncome(Scanner scan, int categories) {
        double totalIncome = 0;
        for (int i=0; i<categories; i++) {
            // retrieve the users income as a double
            System.out.print("Next Income Amount? ");
            totalIncome += scan.nextDouble();
        }

        return totalIncome;
        
    }


    /*
    Method that prompts the user for the month expenses / profit they are looking for
    @param      scan            Scanner object
    @returns    int             int value specifying the month number the user is referencing
    */
    public static int promptWhichMonth(Scanner scan) {
        System.out.print("What is the month number? ");
        return scan.nextInt();
    }


    /*
    Method that returns an integer value specifying the number of days in a specific month
    @param      month           the integer value associating a specific month
    @returns    int             the total days in that specific month
    */
    public static int daysInMonth(int month) {
        int days;
        switch(month) {
            case 2:
                days = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            default:
                days = 31;
                break;
        }
        return days;
        
    }


    /*
    Method that prompts the user to check if there expenses are daily or monthly type expenses
    @param      scan            Scanner object
    @returns    int             int value specifying type of expenses -> 1 for monthly and 2 for daily
    */
    public static int promptDailyOrMonthly(Scanner scan) {
        System.out.print("Enter 1 for monthly or 2 for daily expenses ");
        return scan.nextInt();
    }


    /*
    Method that prompts the user for their total expenses or categories of expenses
    @param      scan            Scanner object
    @returns    int             The total categories or number of expenses the user had
    */
    public static int getExpensesCategories(Scanner scan) {
        System.out.print("How many categories of expenses? ");
        return scan.nextInt();
    }

    /*
    Method that prompts the user for their expenses for a month
    @param      scan            Scanner object
    @param      categories      The value to be used for the for loop to prompt the user for each expense
    @returns    double          The total expenses for a month all added together
    */
    public static double getTotalMonthExpenses(Scanner scan, int categories) {
        double totalExpenses = 0;
        for (int i=0; i< categories; i++) {
            System.out.print("Next Expense amount? ");
            totalExpenses += scan.nextDouble();
        }

        return totalExpenses;
    }

    /*
    Method that prompts the user for their daily expense
    @param      scan            Scanner object
    @param      categories      The value to be used for the for loop to prompt the user for each expense
    @param      daysInMonth     The total amount of days in the month the user specified
    @returns    double          The total expenses for a month all added together; multiplied daily by daysInMonth
    */
    public static double getTotalDailyExpenses(Scanner scan, int categories, int daysInMonth) {
        double dailyExpense = 0;
        for (int i=0; i< categories; i++) {
            System.out.print("Next Expense amount? ");
            dailyExpense = scan.nextDouble();
        }

        return (dailyExpense * daysInMonth);
    }

    /*
    Method that prints the users total expenses and total income as well as daily estimates
    @param      totalIncome     The income categories all added together
    @param      totalExpenses   The total expenses for the month the user specified
    @param      daysInMonth     The days in the month the user is asking information on
    */
    public static void displayTotalIncomeAndExpenses(double totalIncome, double totalExpenses, int daysInMonth) {
        // print the total income line
        System.out.printf("Total Income = %.2f(%.2f per day)\n", totalIncome, totalIncome / daysInMonth);

        // print the total expenses line here
        System.out.printf("Total Income = %.2f(%.2f per day)\n", totalExpenses, totalExpenses / daysInMonth);
    }

    /*
    Method that calculates the net income by subtracting total expenses from total income
    @params     totalIncome     The total income the user had for a month all added together
    @params     totalExpenses   The total expenses the user had for a month multipled by days in month or just the total categories
    @returns    double          The value that is totalIncome minus totalExpenses giving a net profit value.
    */
    public static double calculateNetIncome(double totalIncome, double totalExpenses) {
        return (totalIncome - totalExpenses);
    }

    /*
    Method that displays to the user if they spend too much money or save , dependent on if profit is positive or not
    @params     profit          The net profit the user had for a specific month, can be a negative or positive value
    */
    public static void displayOutput(double profit) {
        if (profit < 0) {
            System.out.printf("You spent %.2f more than you earned this month\n", Math.abs(profit));
            System.out.println("You're a big spender\n");
        } else {
            System.out.printf("You earned %.2f more than you spent this month\n", Math.abs(profit));
            System.out.println("You're a big saver\n");
        }
    }

}
