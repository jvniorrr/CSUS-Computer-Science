class Lstack {

    // fields
    private Node top; // Top of stack
    private int n; // how many items in stakc

    private class Node {
        int item;
        Node next;
    }

    public Lstack() {
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
        if (top == null)    return -1;

        int ret = top.item;
        top = top.next; // reference a new top object; the old will be picked up by the garbage collector
        n--;
        return ret; // return the data
    }

    public int peek() {
        if (n == 0)     return -1;
        return top.item;
    }

    public boolean isempty() {
        return n == 0; // n time operation.
    }

    public int size() {
        return n; // constant time
    }

    public void clear() {
        top = null;
        n = 0;
    }
}