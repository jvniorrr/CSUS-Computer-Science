package Queues;

import java.util.Queue; // reference to Queue class of Java API
import java.util.LinkedList; // Queue class uses linked list to work properly

/**
 * Queue DS using Java's Queue class
 */
public class JavaQueue {
    public static void main(String[] args) {
        // Gotcha for JAva queues is that initialization uses LinkedList on right sign of assignment.
        Queue<String> q = LinkedList<String>(); // Declare & intialize empty queue named "q"

        q.add("String #1");  // Java API uses 'add' instead of 'enqueue'
        q.add("String #2"); // Add second item

        String s = q.remove(); // Java API uses 'remove' instead of 'dequeue'

        String s2 = q.peek(); // Head of queue item placed into s2

        boolean b = q.isEmpty(); // similar to stack; checks if empty using counter/cursor variable

        int n = q.size(); // save number of items left in queue

        q.clear(); // Reset queue to empty; (size() == 0; isEmpty() == true);
    }
    
}
