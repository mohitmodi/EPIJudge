package bigbubuclass;

import java.util.Arrays;

public class NosMissingANdRepeatingInArray {
    public static void main(String[] args) {
        int arr[] = new int[]{3, 1, 2, 5, 3};
        System.out.println(Arrays.toString(find(arr)));
    }

    private static int[] find(int[] arr) {
        int[] range = new int[arr.length + 1];
        int res[] = new int[2];
        for (int i = 0; i < arr.length; i++) {
            range[arr[i]] = range[arr[i]] + 1;
        }
        for (int i = 1; i < range.length - 1; i++) {
            if (range[i] == 0) {
                res[0] = i;
            }
            if (range[i] > 1) {
                res[1] = i;
            }
        }

        return res;
    }
}
