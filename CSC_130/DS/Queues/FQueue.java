package Queues;

/**
 * Queue DS using basic array.
 */
public class FQueue {
    
    /**
     * Methods are
     *  add/enqueue - adds a new item to the tail of the queue. 
     *  remove/dequeue - removes the top of queue. First item that came in, head shifts
     *  peek - returns the top item of the queue, just returns doesn't remove
     *  isEmpty - returns boolean specifying if n == 0.
     *  size - returns the n variable of the Queue collection
     *  clear - clears the Queue collection
     */

    // Fields
    private int[] a;
    private int head;
    private int tail;
    private int n; // n is used to reference size, but may arise errors later due to circular buffers

    // Constructors
    public FQueue() {
        a = new int[256];
        head = 0;
        tail = 0;
        n = 0;
        // one line
        // head = tail = n = 0; // this works properly, just different syntax
    }

    // Methods
    public void enqueue(int item) {
        // this is way to know if queue is full
        if (size() == a.length) return; // no room left to enqueue

        // used to wrap back around; if we reach the end and nothing follows tail then rewrap around
        if (tail >= a.length) {
            // tail = 0;
            // functionality for resizing below
            resize();
        }


        a[tail] = item;
        // a[tail++] = item; // this will increment our tail var after the fact & can remove tail++ below.
        tail++;
        n++;
    }

    public int dequeue() {
        // does checking as well but references the head

        if (isEmpty() ) return -1; // assure we arent empty to not return errors

        // reference the return item
        int ret = a[head];
        // make our head shift 
        head++;
        n--;
        
        // check for wrapping
        if (head >= a.length) {
            head = 0; // reset back to front and wrap around
        }

        return ret;
    }

    public int peek() {
        if (isEmpty() ) {
            return -1; // error code
        }

        return a[head];
    }

    public boolean isEmpty() {
        return size() == 0;
    }
    
    public int size() {
        return n;
    }

    public void clear() {
        // just states whats in the constructor
        head = 0;
        tail = 0;
        n = 0;
    }

    /**
     * Resize functionality
     *  Private so not misused.
     */
    private void resize() {
        int n = a.length * 2;

        int[] b = new int[n];

        int head = 0;
        int tail = 0;

        // TODO: Copy ; try to implement this without using dequeue() or isEmpty()
        while (!isEmpty()) {
            int item = this.dequeue();
            b[tail++] = item;   
        }

        this.head = head;
        this.tail = tail;
        a = b;
    }
}
