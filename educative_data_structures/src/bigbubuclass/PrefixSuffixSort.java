package bigbubuclass;

import java.util.Arrays;

public class PrefixSuffixSort {
    public static void main(String[] args) {
        int arr[] = new int[]{8, 4, 2, 6};
        System.out.println(Arrays.toString(sort(arr)));
    }

    private static int[] sort(int[] arr) {
        int res[] = new int[arr.length];
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;

        while (start < end) {
            if (arr[mid] <= arr[mid - 1] && arr[mid] <= arr[mid + 1]) {
                break;
            } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                end--;
            } else {
                start++;
            }
            mid = start + (end - start) / 2;
        }
        res[0] = arr[mid];


        int i = 1;
        start = mid - 1;
        end = mid + 1;

        while (i < arr.length && start >= 0 && end <= arr.length - 1) {
            if (arr[start] < arr[end]) {
                res[i] = arr[start];
                start = start - 1;
            } else {
                    res[i] = arr[end];
                    end = end + 1;
            }
            i++;
        }
        while (start >= 0) {
            res[i] = arr[start];
            start--;
            i++;
        }
        while (end <= arr.length - 1) {
            res[i] = arr[end];
            end++;
            i++;
        }
        return res;
    }
}
