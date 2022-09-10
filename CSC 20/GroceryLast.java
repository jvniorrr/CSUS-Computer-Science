/*
Name: First Last
Self-Grade: 100
    - Formatted accordingly
    - Methods described along with each instruction
    - Vertical Ruler of 100 used

Date Program Created: 03/18/22
*/



public class GroceryMendoza {


    public static class Driver {
        public static void main(String []args) {
            GroceryList list = new GroceryList();
            list.add("Bread", 5.99, "3/20/2022");
            list.add("Milk", 3.99, "2/1/2002");
            list.add("Chips", 2.99, "12/30/2025");
            list.add("Rice", 35.50, "8/15/2030");
            System.out.println("Here is the list of food items");
            System.out.println(list);
            System.out.println("Here is the most expensive item on the list");
            System.out.println(list.mostExpensive());
            System.out.println("Removing Milk from the list and adding a new expensive item on the list in the 2nd node");
            list.remove("Milk");
            list.add(1, "Truffle", 800, "4/20/2050");
            System.out.println(list);
            System.out.println("Testing the mostExpensive method to see what is the most expensive item now");
            System.out.println(list.mostExpensive());
            System.out.println("Testing the get method to get the item at the 3rd node");
            System.out.println(list.get(2));
        }
    }

    // Class object for a Food Item
    public static class Item implements Comparable<Object> {
        // instance variable
        private String food, expirationDate;
        private double price;

        // constructor
        public Item(String foodName, String expirationDate, double price) {
            this.food = foodName;
            this.expirationDate = expirationDate;
            this.price = price;
        }
        /* GETTER METHODS */

        public String getFood() {
            return this.food;
        }
        public String getExpirationDate() {
            return this.expirationDate;
        }
        public double getPrice() {
            return this.price;
        }

        /* SETTER METHODS */
        public void setFood(String name) {
            this.food = name;
        }
        public void setExpiration(String expirationDate) {
            this.expirationDate = expirationDate;
        }
        public void setPrice(double price) {
            this.price = price;
        }

        // equals: two items are equal if they have the same food and have the same price
        public boolean equals(Item o) {
            return (this.food == o.getFood() && this.price == o.getPrice());
        }

        // compare two items based on the instance variable food
        public int compareTo(Object o) {
            
            Item other = (Item) o;

            return (this.food.compareTo(other.getFood()));
        }

        public String toString() {
            String s = "Food: " + this.food;
            s += "\nPrice: " + this.price + "\nExpiration Date: " + this.expirationDate + "\n";
            return s;
        }
    }

    
   public static class ListNode {
        private Item i;
        private ListNode next;

        /*  CONSTRUCTORS  */
        public ListNode() {
            // item and ListNode attributes will be set to null
        }
        
        public ListNode(Object o) {
            if (o instanceof Item) {
                // intialize the instance var i
                this.i = (Item) o;
            }
        }
        public ListNode(Object o, ListNode next) {
            if (o instanceof Item) {
                this.i = (Item) o;
                this.next = next;
                // 
            }
        }


        /*  GETTER METHODS */
        public Item getItem() {
            return this.i;
        }

        public ListNode getNext() {
            return this.next;
        }

        /*  SETTER METHODS */
        public void setNext(ListNode next) {
            this.next = next;
        }
    }


    public static interface List {
        public void add(String food, double price, String expDate);
        public void add(int index, String food, double price, String expDate);
        public int indexOf(String food);
        public void remove(String food);
        public int size();
        public String toString();
        public Item get(int index);
        public Item mostExpensive();
    }

    public static class GroceryList implements List {
        // instance variables
        private ListNode head; // front of my list
        private static int size=0; // keep track of my list size

        /*  CONSTRUCTOR */
        public GroceryList() {
            head=null;
        }

        public GroceryList(Item item) {
            head = new ListNode(item);
        }

        // implement your code here
        // add the food item to the end of the list
        public void add(String food, double price, String expDate) {
            // create the item to add to grocery list
            Item i = new Item(food, expDate, price);

            // create a node object to store into a linked list
            ListNode n = new ListNode(i);


            // check if the list has anything stored
            if (!(head == null)) {
                ListNode temp = head;

                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }
                // once we get to the last item we will store this value with its node
                temp.setNext(n);
                size++;
                // return;
            } else {
                head = n;
                size++;
            }

        }
        
        // method to add a new node to the linkedList at a specified index
        public void add(int index, String food, double price, String expDate) {
            // create a new Item
            Item item = new Item(food, expDate, price);

            // create a new Node Object
            ListNode n = new ListNode(item);

            // check if the user wants to add this item to the beginning of the list
            if (index == 0) {
                // set our new node to the first index, and its reference is the old 0 index
                n.setNext(head);
                head = n; 
                size++;
                return;
            }

            // loop through the List to add to specified index
            // copy of the front
            ListNode curr = head;
            int i=0;
            // to add to a specific index sub 1 from it due to 0 indexes of 3rd Gen programming languages
            while (curr.getNext() != null && i < index - 1) {
                curr = curr.getNext();
                i++;            
            }

            // set the next node
            n.setNext(curr.getNext());
            curr.setNext(n);
            size++;

        }

        // method to retrieve the index of a specified food item
        public int indexOf(String food) {
            //complete this method
            // check if the list is empty
            if (head == null) {
                return -1;
            }

            // check if the first item is the key we are searching for
            if (food.equals(head.getItem().getFood())) {
                return 0;
            }

            // else the node will be somewhere in the list
            ListNode curr = head;
            int index = 0;
            while (curr.getNext() != null && index <= size) {
                if (curr.getItem().getFood().equals(food)) {
                    return index;
                }

                curr = curr.getNext();
                index++;
            }

            // else if not found we will return -1
            return -1;
        }

        // method to remove a specified food item
        public void remove(String food) {

            // check if the list contains any items
            if (head == null) {
                return;
            }

            // remove the first item if it is that specified one.
            if (head.getItem().getFood().equalsIgnoreCase(food)) {
                // var for the what the new front will be
                head = head.getNext();
            }

            ListNode pre = head;
            ListNode curr = head;

            while (curr != null && !(curr.getItem().getFood().equalsIgnoreCase(food)) ) {
                pre = curr;
                curr = curr.getNext();
            }

            if (curr != null && curr.getNext() == null && (curr.getItem().getFood().equalsIgnoreCase(food)) ) {
                pre.setNext(null);
                size--;
                // System.out.println("The last node was removed.");
            }
            else if (curr == null) {
                System.out.println("Food item was not found.");
            }
            else {
                pre.setNext(curr.getNext());
                size--;
                // System.out.println("A middle node was removed.");
            }

        }

        // method to return the size of our ListNode
        public int size() {
            //complete this method
            return size + 1;
        }

        // method to retrieve a specific item from our ListNode
        public Item get(int index) {
            //complete this method
            // check if the listode has a front item or any items in it
            if (head == null) {
                return null;
            }
            
            // assure the index specified is not larger than our list size
            if (index > size) {
                return null;
            }

            // make a copy of the front of the list
            ListNode curr = head;
            int i =0;
            while (curr != null && i != index) {
                i++;
                curr = curr.getNext();
            }

            // if the Item is not found
            if (curr == null) {
                return null;
            }

            // else the Item was found
            return curr.getItem();
        }

        // method to retrieve the food Item which costs the most
        public Item mostExpensive() {
            // assure the list has items
            if (head == null) {
                // there is not items stored in this list
                return null;
            }

            // copy of the front node
            ListNode temp = head;

            // store the first item of the list as the most expensive then traverse from there
            Item expensiveItem = head.getItem();



            while (temp != null) {

                if (temp.getItem().getPrice() > expensiveItem.getPrice()) {
                    // set the new most expensive item
                    expensiveItem = temp.getItem();
                }
                // at the end of each check set a new temp item; new node
                temp = temp.getNext();
            }
            //complete this method
            return expensiveItem;
        }

        /*  OBJECT REPRESENTATION  */
        public String toString() {
            // assure the list has items
            String s = "";
            if (head == null) {
                return s;
            }

            // copy of the front node
            ListNode curr = head;

            // fencepost to create an array representation
            // s += "{";

            // traverse through the list
            while (curr != null) {
                s += curr.getItem().toString() + "\n";
                // grab the next food item
                curr = curr.getNext();
            }

            // return s + "}";
            return s;

        }
    }
    

    



    /*
    * implement your own driver and test all the methods. Your driver must be very similar to the provided one
    */
    public static class MyDriver
    {
        public static void main(String[] args)
        {
            //your code
            GroceryList list = new GroceryList();
            list.add("Nutter Butter", 2.99, "7/20/2022");
            list.add("Nachos", 3.99, "2/1/2005");
            list.add("Rice Krispie Treat", 15.78, "11/30/2023");
            list.add("Nutella", 15.79, "9/15/2034");
            System.out.println("Here is the list of food items");
            System.out.println(list);
            System.out.println("Here is the most expensive item on the list");
            System.out.println(list.mostExpensive());
            System.out.println("Removing Nutella from the list and adding a new expensive item on the list in the 2nd node");
            list.remove("nutella");
            list.add(2, "Fruit Loops", 10, "2/29/2024");
            System.out.println(list);
            System.out.println("Testing the mostExpensive method to see what is the most expensive item now");
            System.out.println(list.mostExpensive());
            System.out.println("Testing the get method to get the item at the 3rd node");
            System.out.println(list.get(2));
        }
    }
    
}