package LinkedList;

import java.util.LinkedList;


/**
 * Java Linked List class in a general purpose way
 * Java API Linked List
 */
public class generalLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> lst = new LinkedList<Integer>(); // create Linked List object

        for (int i=0; i<10; i++) {
            lst.add(0, i); // Addd 0-9 to list; this is a stack implenentation with index=0. if index = lst.size() acts as queue
        }

        lst.remove(0); // Remove head of Linked List

        for (int i=0; i<lst.size(); i++) {
            System.out.println(lst.get(i) + " "); // Print items in list from head to tail
        }

        System.out.println("\nList contains number 9: " + lst.contains(9));

        lst.clear(); // remove everything from the linked list

        System.out.println(lst.peek()); // should be null

    }
}
