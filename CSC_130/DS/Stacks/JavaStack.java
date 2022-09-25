package Stacks;
import java.util.Stack;

public class JavaStack {
    public static void main(String[] args) {
        Stack<String> st = new Stack<>(); // declare and intialize empty stack

        // adding to stack
        st.push("string #1"); // add first item to stack
        st.push("string #2");  // add second string to stack

        String s = st.pop(); // Capture removed item into string "s"

        String s2 = st.peek(); // Save string at top of stack w/o removing & store into s2.

        boolean b  = st.isEmpty(); // saves whether stack is empty (won't be currently so b = false)

        int n = st.size(); // Save number of items currently stored in our stack, save value into n

        st.clear(); // Reset stack to empty. Clears all items  (size() == 0; isEmpty() == true)
    }
}
