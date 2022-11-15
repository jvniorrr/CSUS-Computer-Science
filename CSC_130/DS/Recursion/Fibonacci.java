package Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        
    }

    // recursive call works but it is inefficient; EXPONENTIAL TIME
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    // iterative solution has a better time complexity ; this is LINEAR TIME
    public static int fibIterative(int n) {
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        for (int i = 1; i < n; i++) {
            n1 = n2;
            n2 = n3;
            n3 = n1 + n2;
        }
        return n3;
    }

    // This is the iterative code above converted, however it is ugly to a normal user. 
    // since this code is ugly to the normal user we can use abstraction by making this method the 'workhorse method' and create a different initializer that makes a call to this.
    public static int fibConverted(int n, int n1, int n2, int n3, int i) {
        if (i == n) {
            return n3;
        }
        return fibConverted(n, n2, n3, n2+n3, i+1);
    }
}
