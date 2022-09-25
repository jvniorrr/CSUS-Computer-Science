package Stacks;

/**
 * Fixed-sized Array implementation in a Stack DS.
 */
public class FStack {
    // Fields
    private int[] a;
    private int cursor; // used to track current pos and knowing where to push

    // Constrcutor
    public FStack() {
        a = new int[256];
        cursor = 0;
    }

    // Methods
    public void push(int item) {
        // Prevent buffer overrun
        if (cursor >= a.length) {
            return;
        }

        a[cursor] = item;
        cursor++;
    }

    public int pop() {
        int ret = -1; // Set to error code

        // assure our stack not empty
        if (cursor > 0) {
            // retrive item and decrease cursor val
            cursor--;
            ret = a[cursor];
        }
        return ret;
    }

    public int peek() {
        int ret = -1; // Set to error code

        // assure our stack not empty
        if (cursor > 0) {
            ret = a[cursor - 1];
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
        cursor = 0; // Lazuy implementation & save cycles.
    }
}
