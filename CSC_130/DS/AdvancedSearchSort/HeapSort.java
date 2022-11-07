package AdvancedSearchSort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] a = { 4, 7, 5, 6, 3, 1, 2, 9 };
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void heapSort(int[] a) {
        final int n = a.length;

        // build heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            buildHeap(i, n, a);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            // call helper method
            buildHeap(0, i, a);

        }
    }

    /* Heap sort helper method */
    private static void buildHeap(int i, int n, int a[]) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && a[left] > a[max]) {
            max = left;
        }

        if (right < n && a[right] > a[max]) {
            if (i != max) {
                int swap = a[i];
                a[i] = a[max];
                a[max] = swap;

                // Recursive call
                buildHeap(max, n, a);
            }
        }
    }

}
