/*
Name: First Last
Self-Grade: 100
    - Formatted accordingly
    - Methods described along with each instruction
    - Vertical Ruler of 100 used

Date Program Created: 04/29/22
*/

// import modules
import java.util.*;

public class QueueLast {

    // QUEUE OBJECT
    public static class Queue {
        // attribute
        ArrayList<Integer> list;

        // constructor
        public Queue() {
            list = new ArrayList<Integer>();
        }

        // Add a new item to our queue list
        public void enqueue(Integer num) {
            list.add(num);
        }

        // Remove an item our queue list
        public Integer dequeue() {
            return list.remove(0);
        }

        // OBJECT REPRESENTATION
        public String toString() {
            String s = "";
            Queue copy = new Queue();
            boolean b = false;
            while (!b) {
                try {
                    int num = this.dequeue();
                    copy.enqueue(num);
                    s = s + " " + num;
                } catch (Exception e) {
                    b = true;
                }
            }
            // System.out.println(copy.list+ "&&&&");
            restore(copy);
            return s;
        }

        // Method that returns the largest integer value in our queue list
        public int getMax() {
            Queue copy = new Queue();
            boolean b = false;
            int max = this.peek();
            while (!b) {
                try {
                    int num = this.dequeue();
                    if (num > max)
                        max = num;
                    copy.enqueue(num);

                } catch (Exception e) {
                    b = true;
                }
            }
            restore(copy);
            return max;
        }

        public void restore(Queue q) {
            boolean b = false;
            while (!b) {
                try {
                    this.enqueue(q.dequeue());
                } catch (Exception e) {
                    b = true;
                }
            }
        }

        // *******************implement the following methods***************
        // Method that returns the smallest integer value stored in the queue list
        public Integer getMin() {
            Queue copy = new Queue();
            boolean b = false;
            int min = this.peek();
            while (!b) {
                try {
                    int num = this.dequeue();
                    if (num < min)
                        min = num;
                    copy.enqueue(num);

                } catch (Exception e) {
                    b = true;
                }
            }
            restore(copy);
            return min;

        }

        // Method that reverses the order of our program
        public void reverseOrder() {
            // create a stack object
            Stack<Integer> s = new Stack<Integer>();

            Boolean b = false;

            while (!b) {
                try {
                    // retrieve the first element
                    int element = this.dequeue();

                    // add the element to the extra storage stack
                    s.push(element);
                } catch (Exception e) {
                    b = true;
                }
            }

            // pop the stack
            b = false;
            while (!b) {
                try {
                    int element = s.pop();
                    this.enqueue(element);

                } catch (Exception e) {
                    b = true;
                }
            }
        }

        // Method that calculates the avg of all our elements
        public double getAverage() {
            int sum = 0, count = 0;
            // declare a queue copy to restore the original queue
            Queue q = new Queue();
            Boolean b = false;

            while (!b) {
                try {
                    int element = this.dequeue();

                    // add our new element to the copy of the queue
                    q.enqueue(element);
                    sum += element;
                    count++;

                } catch (Exception e) {
                    b = true;
                }
            }

            // restore to our original queue list
            this.restore(q);

            return (double) (sum) / count;
        }

        // Method that checks if a slist is sorted or not
        public boolean isSorted() {

            // create queue object
            Queue q = new Queue();

            Boolean b = false, sorted = true;

            while (!b) {
                try {
                    int n1 = this.dequeue();
                    int n2 = this.dequeue();
                    q.enqueue(n1);
                    q.enqueue(n2);

                    // check order here
                    if (n1 > n2) {
                        sorted = false;
                    }
                } catch (Exception e) {
                    b = true;
                }
            }

            this.restore(q);
            // return if queue is sorted
            return sorted;
        }
        // ****************************************************
        /*
         * add a method of your choice to this queue class
         * Method just returns the first element in our queue / liss, it doesn't actually remove it. 
         * points for this method is 10
         */
        public int peek() {
            return list.get(0);
        }

    }

    public static class Driver {
        public static void main(String[] args) {
            // copy and paste the given driver here
            Queue m = new Queue();
            m.enqueue(10);
            m.enqueue(12);
            m.enqueue(15);
            m.enqueue(7);
            m.enqueue(100);
            m.enqueue(22);
            System.out.println("The queue is : " + m);
            m.reverseOrder();
            System.out.println("The queue in the reverse order is: " + m);
            // reverse the queue back to its original order
            m.reverseOrder();
            System.out.println("Queue is back to its original state: " + m);
            System.out.printf("Average = %.2f\n", m.getAverage());
            System.out.println("Max = " + m.getMax());
            System.out.println("Min = " + m.getMin());
            System.out.println("The list is sorted: " + m.isSorted());
        }
    }

    public static class yourDriver {
        public static void main(String[] args) {
            // fill in with your own code testing all the methods in the queue class
            Queue m = new Queue();
            m.enqueue(10);
            m.enqueue(12);
            m.enqueue(15);
            m.enqueue(17);
            m.enqueue(23);
            m.enqueue(50);
            m.enqueue(100);
            m.enqueue(500);

            // print the queue and how it is stored
            System.out.println("The queue is : " + m);
            m.reverseOrder();
            System.out.println("The queue in the reverse order is: " + m);
            // revert back to the original queue form first in.
            m.reverseOrder();
            System.out.println("Queue is back to its original state: " + m);


            // print the first element of our queue list
            System.out.println("The first element is: " + m.peek());

            // print the min and max of this queue
            System.out.println("Max = " + m.getMax());
            System.out.println("Min = " + m.getMin());

            // print the average of our queue elements
            System.out.printf("Average = %.2f\n", m.getAverage());

            // print if our queue is sorted
            System.out.println("The list is sorted: " + m.isSorted());
        }
    }
}
