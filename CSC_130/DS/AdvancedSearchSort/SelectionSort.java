package AdvancedSearchSort;

public class SelectionSort {
    public static void main(String[] args) {

    }

    /**
     * Selection sort is not considered an optimal sorting algorithm though.
     * Selection sort has a O(n * n/2) time efficiency.
     */
    public static void selectionSort(int[] a) {
        for (int j = 0; j < a.length - 1; j++) {
            for (int i = j + 1; i < a.length; i++) {
                if (a[j] > a[i]) {
                    int swap = a[j];
                    a[j] = a[i];
                    a[i] = swap;
                }
            }
        }
    }
}
