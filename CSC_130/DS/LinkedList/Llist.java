package LinkedList;

/*
 * Linked List from scratch
 * Node implementation that is used as an essential pointer to reference next object.
 */
public class Llist {
    // Fields
    private Node head; // reference, holds me address to next address.
    private int n; // holds counter var; size
    
    // Subclass
    private class Node {
        String item; // This Linked List will hold Strings
        Node next;
    }

    // Constructors
    public Llist() {
        head = null;
        n = 0;
    }

    // Methods
    public void add(int index, String item) {
        // create node to add 
        Node X = new Node();
        X.item = item;
        X.next = null;

        // check for strange use cases...

        // if our linked list is empty
        if (head == null) {
            if (index != 0) return; // not valid index relative to current list ; not legal value since our counter var is > 0 and dont have a head

            head = X;
            n++;
            return;
        } else if (head != null && index == 0) {
            // if do this if block repeatedly it is essentially a stack
            // this means our linked list isnt empty but want to replace our head value.
            X.next = head; // reference the old head, and make it the next item.
            head = X; // reset the head
            n++;
            return;
        }


        // Otherwise, traverse the linked list for index position
        if (index > n) return; // Cannot insert at an index larger than n

        // what we will use to traverse through linked list
        Node current = head;
        Node previous = null;

        int i = 0;

        while (i < index) {
            previous = current;
            current = current.next; // pass reference 

            if (current == null) break; // assure our last value isnt null which will return a NullPpinterException
            i++;
        }
        X.next = current;
        previous.next = X;
        n++;
    }

    // bad implementation since n^2 complexity.
    public boolean contains(String item) {
        // traverse the linked list to check if value is stored. 
        for (int i=0; i<n; n++) {
            if (get(i).equals(item)) {
                return true;
            }
        }
        return false;
    }


    public String get(int index) { // can change params to (String item)
        if (index > n-1) return "Invalid index"; // General error / return
        if (index == 0) return head.item;

        Node cur = head;
        int i =0;
        // traverse to find correct node to "get" item from...
        while (i < index) {
            /* if (item.equals(cur.item)) {
                // this portion goes in contain to make more efficient. 
                return true;
            } */
            cur = cur.next;
            i++;
        }

        // to make more efficient
        return cur.item;
    }

    public String peek() {
        if (head != null) return head.item;
        return "Null"; // Safe return!
    }

    public void remove(int index) {
        // Strange cases first...
        if (index > n-1) return; // Cannot remove from index that doesnt exist

        if (head != null && index == 0) {
            head = head.next;
            n--;
            return;
        }

        // Oterhwise traverse the linked list for the index of node to remove
        Node current = head;
        Node previous = null;

        int i = 0;
        // iterate if user provides index > 1
        while (i < index) {
            previous = current;
            current = current.next;

            if (current == null) break;
            i++;
        }

        previous.next = current.next;
        n--;
    }

    public int size() {
        return n;
    }

    public void clear() {
        head = null;
        n = 0;
    }
}
