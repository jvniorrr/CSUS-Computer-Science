package BinaryTrees;

import java.util.LinkedList;

import java.util.Queue;

public class BST {

    // Fields
    private Node root; // Top-level node in tree
    private int n; // Number of nodes in tree
    private Queue<Integer> q; // Used for the inorder toString method

    // Subclass
    public class Node {
        // Node Fields
        int key;
        Node left;
        Node right;

        // Constructor
        public Node(int key) {
            this.key = key;
            left = right = null;
        }

    }

    // Constructor
    public BST() {
        root = null;
        n = 0;
    }

    // Methods
    public void insert(int key) {
        root = insertHelper(root, key);
    }

    // method to be used only within our class; helper method; hide implementation details
    private Node insertHelper(Node root, int key) {
        // root refers to the child / parent object being passed
        if (root == null) {
            root = new Node(key);
            n++;
            return root;
        }

        // reference the value stored in root, check if newly inserted item is smaller or larger in value
        if (key < root.key) {
            root.left = insertHelper(root.left, key);
        } else if (key > root.key) {
            // means our value being passed is larger than our root's value
            root.right = insertHelper(root.right, key);
        }
        return root;
    }

    public boolean search(int key) {
        return searchHelper(root, key);
    }
    // method to be used only within our class; helper method; hide implementation details
    private boolean searchHelper(Node root, int key) {
        // means reached end of tree but didnt find what we were looking for. 
        if (root == null)
            return false;
        // means we found our valuea already stored. 
        if (root.key == key)
            return true;

        if (key < root.key)
            return searchHelper(root.left, key);

        return searchHelper(root.right, key);

    }

    public void delete(int key) {
        root = deleteHelper(root, key);
    }
    // method to be used only within our class; helper method; hide implementation details
    private Node deleteHelper(Node root, int key) {

        if (root == null)
            return null;

        if (key < root.key) {
            root.left = deleteHelper(root.left, key);
        } 
        else if (key > root.key) {
            root.right = deleteHelper(root.right, key);
        } else {
            // this were we assure this the one we want to get rid of.
            // wanna make sure no nodes are connected below
            if (root.left == null) {
                n--;
                return root.right;
            }
            else if (root.right == null) {
                n--;
                return root.left;
            }

            // Here is where we decide how to delete...
            root.key = minNodeKey(root.right);
            root.right = deleteHelper(root.right, root.key);
        }
        return root;
    }

    private int minNodeKey(Node root) {
        // trying to find out how fat there is a connection. 
        int min = root.key;

        while (root.left != null) {
            min = root.left.key;    
            root = root.left;
        }
            

        return min;

    }

    public int size() {
        return n;
    }

    public void clear() {
        root = null;
        n = 0;
    }

    /* This will return the keys of the BST in an inorder traversal */
    public String toString() {
        String ret = "[";

        q = new LinkedList<Integer>();
        inorder(root);

        while (!q.isEmpty()) {
            ret += q.remove() + ",";
        }

        ret = ret.substring(0, ret.length() - 1);

        ret += "]";

        return ret;

    }

    private void inorder(Node node) {

        if (node == null)
            return;

        inorder(node.left);

        q.add(node.key);

        inorder(node.right);

    }

}