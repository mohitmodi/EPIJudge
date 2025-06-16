package bigbubuclass;

import java.util.Arrays;

public class EvensBeforeOdds {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2};
        System.out.println(Arrays.toString(evensBeforeOdd(arr)));
    }

    private static int[] evensBeforeOdd(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (arr[left] % 2 == 0) {
                left++;
            }
            if (arr[right] % 2 != 0) {
                right--;
            }
            swap(left, right, arr);
        }
        return arr;
    }

    private static void swap(int left, int right, int[] arr) {
        if (left <= right && arr[left] % 2 != 0 && arr[right] % 2 == 0) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }
}
