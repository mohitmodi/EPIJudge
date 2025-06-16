package bigbubuclass;

import java.util.Arrays;

public class MinimumWindowForSorted {
    //notdone
    //Given an array of integers out of order,
    // determine the bounds of the smallest window that
    // must be sorted in order for the entire array to be sorted.
    // For example, given [3, 7, 5, 6, 9], you should return (1, 3).
    public static void main(String[] args) {
        int arr[] = new int[]{3, 7, 5, 6, 9};
        System.out.println(Arrays.toString(minWindow(arr)));
    }

    private static int[] minWindow(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1] && arr[start] < arr[i]) {
                start = i;
            }
        }
        for (int j = arr.length - 1; j > 0; j--) {
            if (arr[j] < arr[j - 1] && arr[end] > arr[j]) {
                end = j;
            }
        }
        return new int[]{start, end};
    }
}
