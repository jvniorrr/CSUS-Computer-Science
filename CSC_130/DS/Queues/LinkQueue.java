package Queues;

/**
 * Queue DS using Linked Lists.
 */
public class LinkQueue {
    // Fields
    private Node head;
    private Node tail;
    private int n;
    

    private class Node {
        int item;
        Node next;
    }

    // Constructors
    public LinkQueue() {
        head = null;
        tail = null;
        n = 0;
    }

    // Methods
    public void enqueue(int item) {
        Node oldTail = tail; // backup the old tail
        tail = new Node(); // create a new tail
        tail.item = item; // populate item
        tail.next = null; // set the new tails to point to null since its last item

        // if the linkedlist is empty then we set a new head
        if (isEmpty() ) head = tail;
        // if not we will add to the end of our queue
        else oldTail.next = tail;
        n++;
    }

    public int dequeue() {
        // check if our queue is not empty
        if (n == 0) return -1;

        // return the old head object and set a new head object once removed.
        int item = head.item;
        head = head.next; // may be null so reference in next?

        // check after we have retrieved the first item if our queue is empty
        if  (isEmpty() ) { tail = null; }

        n--;
        return item;
    }

    /**
     * Method to just peek, doesn't pop. Just sees whats at top of queue
     * @return Int value at top of queue
     */
    public int peek() {
        if (n == 0) return -1; // error code
        return head.item;
    }

    public boolean isEmpty() {
        return head == null;
        // can be n == 0 or tail = null
    }

    public int size() {
        return n;
    }

    public void clear() {
        head = null;
        tail = null; // old nodes have nothing pointing to them so garbage collector picks up other nodes.
        n = 0;
    }
}
