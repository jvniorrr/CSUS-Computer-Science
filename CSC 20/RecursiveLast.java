/*
Name: First Last
Self-Grade: 100
    - Formatted accordingly
    - Methods described along with each instruction
    - Vertical Ruler of 100 used

Date Program Created: 05/02/22
*/

import java.util.*;

public class RecursiveLast {

    public static class Driver {
        public static void main(String[] args) {
            System.out.println("testing the palindrom method");
            int[] a = { 5, 6, 4, 5, 8, 5, 4, 6, 5, 12 };
            System.out.print(Arrays.toString(a) + " is palindrome?  ");
            System.out.println(palindrome(a, 0));

            int[] b = { 1, 2, 3, 4, 3, 2, 1 };
            System.out.print(Arrays.toString(b) + " is palindrome?  ");
            System.out.println(palindrome(b, 0));

            System.out.println("\ntesting sum of the digits");
            int num = 12345;
            System.out.println("The sum of the digits in " + num + " is " + sum(12345));

            System.out.println("\ntesting longest string in an array of string");
            String[] s = { "Hello", "Bye", "Said", "song", "Building" };
            System.out.println("The longest string is the array " + Arrays.toString(s) + " is " + longest(s, 1, s[0]));

            System.out.println("\ntesing the equals method on the strings");
            String s1 = "hello";
            String s2 = "helloo";
            System.out.println("are the strings " + s1 + " and " + s2 + " equal? " + RecursiveLast.equals(s1, s2, 0));

            s1 = "tomorrow";
            s2 = "tomorrow";
            System.out.println("are the strings " + s1 + " and " + s2 + " equal? " + RecursiveLast.equals(s1, s2, 0));

            System.out.println("\ntesting the sum of the integers in a link list");
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.add(5);
            list.add(7);
            list.add(8);
            list.add(12);
            System.out.println("The sum of the numbers in the linklist " + list + " is " + listSum(list, 0));
        }
    }



    /**
     *  STATIC METHODS TO BE USED IN ASSIGNMENT
     */
    // write a method that accepts an array of String and returns
    // true if the array is palindrom and returns false otherwise
    public static boolean palindrome(int[] a, int index) {

        // compare index at end and start of each
        if (index == a.length / 2) {
            return true;
        }

        return a[index] == a[a.length - 1 - index] && palindrome(a, index + 1);
    }

    // write a recursive method that accepts an integer as its parameter and returns
    // the sum of the digits in teh given number
    // for example sumDigit(1234) should return 1 + 2 + 3 + 4 = 10
    public static int sum(int num) {
        // your code

        // base case of recursion; check if stilll a  digit
        if (num == 0) return 0;

        // get the digit; however this gets the reverse order of our integer string 
        // so reverse it with recursion
        // split the digit and return it in the recursive call
        return (num % 10) + sum(num / 10);

    }

    // write a method that accepts an array of String and returns the string with
    // the longest length
    public static String longest(String[] s, int index, String longest) {
        // your code
        // base case
        if (index == s.length) {
            return longest;
        }

        // check which string is longer
        if (s[index].compareToIgnoreCase(longest) < 0) {
            longest = s[index];
        }

        return longest(s, index  + 1, longest);
    }

    // write a recursive method that accepts two string paramters, returns tru if
    // the strings are the same,false otherwise
    public static boolean equals(String s1, String s2, int index) {
        // your code
        // check if the strings are the same size
        if (s1.length() != s2.length()) return false;
        if (index == s1.length()) return true;
        if (s1.charAt(index) != s2.charAt(index)) return false;

        return true && equals(s1, s2, index + 1);
    }

    // write a method that accepts a linklist of integers and finds the sum of all
    // the numbers in the list
    public static int listSum(LinkedList<Integer> list, int index) {
        // your code

        // check the size of our linked list
        if (list.size() <= index) return 0;

        // return the sumation of all our integers stored using recursion
        return (Integer)list.get(index) + listSum(list, index  + 1);
    }
}
