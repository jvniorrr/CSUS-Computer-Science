package Stacks;

/**
 * Linked List implementation in a Stack DS.
 */
public class LStack {
    
    // fields
    private Node top; // Top of stack
    private int n; // how many items in stakc

    // Subclassing; tiny implementation of it
    private class Node {
        int item; // Hold the discrete item (value) in node
        Node next; // Reference to next node in list
    }

    // Constructor
    public LStack() {
        top = null; 
        n = 0;
    }

    // Methods
    public void push (int item) {
        Node oldTop = top; // reference the old top
        top = new Node(); // create a new node object
        top.item = item; // data
        top.next = oldTop; // top is top of stack so reference old top obj
        n++;
    }

    public int pop() {
        if (top == null) {
             return -1; // Set error code
        }

        int ret = top.item;
        top = top.next; // reference a new top object; the old will be picked up by the garbage collector
        n--;
        return ret; // return the data
    }

    public int peek() {
        if (n == 0) {
            return -1; // Set error code
        }
        return top.item;
    }

    public boolean isEmpty() {
        return n == 0; // n time operation.
    }

    public int size() {
        return n; // constant time
    }

    public void clear() {
        top = null; // Java garbage collection will auto handle trashing rest of nodes / Linked List items. 
        n = 0;
    }
}
