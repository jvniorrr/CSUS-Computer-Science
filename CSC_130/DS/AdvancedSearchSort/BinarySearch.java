package AdvancedSearchSort;

public class BinarySearch {
    public static void main(String[] args) {

    }


    /** Returns the index of the matching value (or -1 if not found) */
    public static int binarySearch(int a[], int val) {

        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int pivot = start + (end - start) / 2;
            if (a[pivot] == val) {
                return pivot;
            }

            if (a[pivot] < val) {
                start = pivot + 1;
            } else {
                end = pivot - 1;
            }
        }

        // Failed search
        return -1;
    }
}
