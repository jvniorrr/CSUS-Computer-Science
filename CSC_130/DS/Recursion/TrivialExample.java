package Recursion;

public class TrivialExample {
    public static void main(String[] args) {
        recursivePrint(0, 3);
    }

    public static void recursivePrint(int i, int n) {
        if (i > n) return;

        System.out.println(i);
        recursivePrint(i+1, n);
    }
}
