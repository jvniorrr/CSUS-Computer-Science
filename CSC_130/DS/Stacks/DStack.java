package Stacks;

/**
 * Dynamically-sized Array implementation in a Stack DS.
 * Need private method size() that will resize array to double previous size
 */
public class DStack {
    // Fields 
    private int[] a;
    private int cursor;

    // Constructor
    public DStack() {
        a = new int[256]; // Start @ power of 2
        cursor = 0;
    }

    // Methods
    private void resize() {
        int n = a.length * 2;
        int[] b = new int[n];

        // iterate through old Array and copy all items / elements - O(n)
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i]; 
        }
        a = b;
    }

    public void push(int item) {
        if (cursor >= a.length) {
            // Resize here since our stack has reached its limit
            resize();
        }
        a[cursor] = item;
        cursor++;
    }

    public int pop() {
        int ret = -1; // Set to error code
        if (cursor > 0) {
            cursor--;
            ret = a[cursor];
        }
        return ret;
    }

    public int peek() {
        int ret = -1; // Set to error code
        if (cursor > 0) {
            ret = a[cursor-1];
        }
        return ret;
    }

    public boolean isEmpty() {
        return cursor == 0;
    }

    public int size() {
        return cursor;
    }

    public void clear() {
        cursor = 0; // Lazy implementation & saves cycles, Will just reassign each value as stack increases with size.
    }
}
