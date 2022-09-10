/*
Name: First Last
Self-Grade: 100
    - Formatted accordingly
    - Methods described along with each instruction
    - Vertical Ruler of 100 used

Date Program Created: 04/14/22
*/

import java.util.*;

public class StackMendoza {

    public interface myStack {
        public void push(String s);
        public String peek();
        public boolean isEmpty();
        public String pop();
    }

    // CLASS that represents our Stack data structure
    public static class Stack implements myStack {
        // Array list to store objects
        private ArrayList<Object> list;
        private int top; // index of the top of the stack

        // constructor
        public Stack() {
            list = new ArrayList<Object>();
            top = 0;
        }

        // method to place a new Object at the top of the stack or list
        public void push(String s) {
            // add the new Object/String to top of the stack
            list.add(s);
            // increment our top index
            top++;
            
        }

        // method to return a copy of the element at the top of the stack
        public String peek() {
            // assure list is not empty
            while (!isEmpty()) {
                return (String) list.get(top - 1);
            }
            // else we will return false
            return null;
        }


        // method to reference is the list is empty or size being 0.
        public boolean isEmpty() {
            // return if the list is empty; simple T/F statement
            return list.size() == 0;
        }


        // method that returns the Object/String and removes it from the top of the stack or list
        public String pop() {
            // assure the list is not empty
            while (!isEmpty()) {
                // subtract from the top index
                top--;
                // convert our object
                String o = (String)list.get(top);
                // remove that object from top of stack or list
                list.remove(top);
                return o;
            }
            // if nothing is in the list then return null
            return null;
        }


        // OBJECT REPRESENTATION
        public String toString() {
            return list.toString();
        }
    }

    // CLASS object to change from infix to post fix and calculations
    public static class Expression {
        private String exp;  // instance variable

        // constructor
        public Expression(String s)
        {
            exp = s;
        }

        // method that changes from infix to post fix returns that string
        public String getPostfix()
        {
            String postFixString = "";
            Stack stackObj = new Stack();

            StringTokenizer st = new StringTokenizer(this.exp, " ");
            while (st.hasMoreTokens()) {
                String token = st.nextToken();

                // check if token is any of the operators
                if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    // get precedence of the operations
                    int precedence = precedence(token);

                    // if precedence is 3; if token is * or /
                    if (precedence == 3) {
                        while (!stackObj.isEmpty() && precedence(stackObj.peek()) >= 3) {
                            // pop the element at the top of the stack
                            // concatenate it to the postfix expression
                            postFixString += stackObj.pop() + " ";
                        }
                    } 
                    // if token is + or -
                    else if (precedence == 2) {
                        while (!stackObj.isEmpty() && precedence(stackObj.peek()) >= 2) {
                            // pop the element at the top of the stack
                            // concatenate it to the postfix expression
                            postFixString += stackObj.pop() + " ";
                        }
                    }
                    // push the token to the top of the stack
                    stackObj.push(token);

                }
                // if the token is a number instead
                else {
                    postFixString += token + " ";
                }
                
            }

            while (!stackObj.isEmpty()) {
                postFixString += stackObj.pop() + " ";
            }

            return postFixString;
                
        }

        // method used within this class to check precendence of an operator
        private static int precedence(String opr)
        {
            if (opr.equals("*") || opr.equals("/")) {
                return 3;
            } else if (opr.equals("+") || opr.equals("-")) {
                return 2;
            }
            return 0;
        }

        // method to calculate a post fix string
        public int evalPostfix()
        {   
            String post = this.getPostfix();
            // create a stack object
            Stack stackObj = new Stack();

            StringTokenizer st = new StringTokenizer(post, " ");

            while (st.hasMoreTokens()) {
                String token = st.nextToken();

                // check if the token is an operator
                // if the token is an operand push it to the stack
                if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/") ) {
                    // push this token to the stack
                    stackObj.push(token);
                }
                // else if it is an operand add it to the stack
                else {


                    int num1 = Integer.parseInt(stackObj.pop());
                    // System.out.println(num1);
                    int num2 = Integer.parseInt(stackObj.pop());

                    // call calculate method and add that to result
                    int calcResult = calculate(num1, num2, token);

                    // add this result to the stack
                    stackObj.push("" + calcResult + "");
                }
            }

            return Integer.parseInt(stackObj.pop());
        }
            
        // method to calculate a single 2 number expression that is in postfix form
        private int calculate(int num1, int num2, String opr)
        {
            switch(opr) {
                case "*":
                    return num1 * num2;
                case "/":
                    return (int) ( (double) num2 / num1 );
                case "-":
                    return num2 - num1;
                case "+":
                    return num1 + num2;
                default:
                    return 0;
            }
        }
    }

    // School class testing and assuring program runs fine
    public static class ExpDrive {
        public static void main(String[] args) {
            // String s = "5 - 2";
            ArrayList <String> exp = new ArrayList<String>();
            exp.add("2 + 3 + 7 * 4 - 2 / 3");
            exp.add("3 - 4 / 2 + 6 * 3");
            exp.add("5 * 6 - 8 + 2 * 10");
            exp.add("4 + 8 * 3 - 2 / 34");
            exp.add("6 - 3 + 6 / 2 * 4 - 8");
            for(int i = 0; i < exp.size(); i++)
            {
                Expression e1 = new Expression(exp.get(i));
                String post = e1.getPostfix();
                int result = e1.evalPostfix();
                System.out.println("Infix: "+ exp.get(i) + ",  postfix: " + post + " = " + result);
            }
     
        }
    }

    // my class created by me
    public static class MyExpDrive {
        public static void main(String[] args) {
            ArrayList <String> exp = new ArrayList<String>();
            exp.add("5 + 10 + 8 * 9 + 8 / 1");
            exp.add("2 - 4 * 5 - 8 * 2");
            exp.add("8 / 4 - 8 + 6 * 11");
            exp.add("3 * 6 + 2 - 5 / 26");
            exp.add("8 - 9 + 4 / 2 * 3 - 6");
            for(int i = 0; i < exp.size(); i++)
            {
                Expression e1 = new Expression(exp.get(i));
                String post = e1.getPostfix();
                int result = e1.evalPostfix();
                System.out.println("Infix: "+ exp.get(i) + ",  postfix: " + post + " = " + result);
            }
            
        }
    }
}
