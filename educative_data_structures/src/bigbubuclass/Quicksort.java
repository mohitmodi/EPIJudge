package bigbubuclass;

import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) {
        int arr[] = new int[]{10, 7, 8, 9, 16, 5, 3, 27};
        int k = 5;
        System.out.println(Arrays.toString(sort(arr)));
        // System.out.println(Arrays.toString(smallestKNumbers(arr, k)));
    }

    /*private static int[] smallestKNumbers(int[] arr, int k) {

    }
*/

    private static int[] sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quicksort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotPosition = partition(arr, left, right);
            quicksort(arr, left, pivotPosition - 1);
            quicksort(arr, pivotPosition + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
