package bigbubuclass;

public class KsmallestNos {
    public static void main(String[] args) {
        int arr[] = new int[]{10, 7, 8, 9, 16, 5, 27,3};
        int k = 7;
        smallest(arr, k);
        for (int i = 0; i < k; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void smallest(int[] arr, int k) {
        quickSort(arr, k, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int k, int left, int right) {
        if (left >= right) return;
        int pivotIndex = helper(arr, left, right);
        int numOnLeft = pivotIndex - left + 1;
        if (k < numOnLeft) {
            quickSort(arr, k, left, pivotIndex - 1);
        } else if (k > numOnLeft) {
            quickSort(arr, k - numOnLeft, pivotIndex + 1, right);
        }
    }

    private static int helper(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
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
