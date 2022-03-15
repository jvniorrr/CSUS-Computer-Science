import java.util.*;

public class ArraysAndMethods {
    public static void main(String[] args) {
        // int[] list = new int[5];
        int[] list = buildOddArray(5);
        // fillWithOdds(list);

        System.out.println(Arrays.toString(list));
    }

    public static void fillWithOdds(int[] data) {
        for (int i=0; i<data.length; i++) {
            data[i] = 2* i + 1;
        }
    }

    public static int[] buildOddArray(int size) {
        int[] data = new int[size];

        for (int i=0; i<data.length; i++) {
            data[i] = 2 * i + 1;
        }

        return data;
    }
}
