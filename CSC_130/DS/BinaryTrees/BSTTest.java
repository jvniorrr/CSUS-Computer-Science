package BinaryTrees;

public class BSTTest {

    public static void main(String[] args) {
        // Tester array to insert into BST
        int[] a = { 5, 3, 7, 2, 4, 6, 8 };

        BST bst = new BST();

        for (int i = 0; i < a.length; i++)
            bst.insert(a[i]); // Insert values here...

        System.out.println(bst.size()); // Print the size

        // check for a value
        System.out.println("Check for a value 8: " + bst.search(8));
        System.out.println("Check for a value 15: " + bst.search(15));
        bst.delete(8);
        System.out.println("AFTER DELETE");
        System.out.println("Check for value 8: " + bst.search(8));
        System.out.println(bst);

        // for (int i = 0; i < 10; i++) {
        //     System.out.println("Searching for " + i + " and result is: " + bst.search(i));
        // }

        // System.out.println(bst.toString()); // Display the BST using inorder traversal

    }

}
