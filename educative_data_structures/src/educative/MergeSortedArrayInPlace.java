package educative;

import java.util.Arrays;

public class MergeSortedArrayInPlace {
    public static int[] mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m - 1;
        int ptr2 = n - 1;
        int ptr3 = nums1.length - 1;
        while (ptr1 >= 0 && ptr2 >= 0) {
            if (nums1[ptr1] > nums2[ptr2]) {
                int temp = nums1[ptr1];
                nums1[ptr1] = nums1[ptr3];
                nums1[ptr3] = temp;
                ptr1--;
                ptr3--;
            } else {
                nums1[ptr3] = nums2[ptr2];
                ptr2--;
                ptr3--;
            }
        }
        while (ptr1 >= 0) {
            int temp = nums1[ptr1];
            nums1[ptr1] = nums1[ptr3];
            nums1[ptr3] = temp;
            ptr1--;
            ptr3--;
        }
        while (ptr2 >= 0) {
            nums1[ptr3] = nums2[ptr2];
            ptr2--;
            ptr3--;
        }
        return nums1;
    }

    public static void main(String args[]) {
        int[] m = {5, 9, 2, 3, 1, 8};
        int[] n = {5, 6, 1, 4, 2, 1};
        int[][] nums1 = {
                {6, 7, 8, 9, 10, 0, 0, 0, 0, 0},
                {23, 33, 35, 41, 44, 47, 56, 91, 105, 0, 0, 0, 0, 0, 0},
                {1, 2, 0},
                {1, 1, 1, 0, 0, 0, 0},
                {6, 0, 0},
                {12, 34, 45, 56, 67, 78, 89, 99, 0}
        };
        int[][] nums2 = {
                {1, 2, 3, 4, 5},
                {32, 49, 50, 51, 61, 99},
                {7},
                {1, 2, 3, 4},
                {-45, -99},
                {100}
        };
        int k = 1;
        for (int i = 0; i < m.length; i++) {
            System.out.print(k + ".\tnums1: [");
            for (int j = 0; j < nums1[i].length - 1; j++) {
                System.out.print(nums1[i][j] + ", ");
            }
            System.out.println(nums1[i][nums1[i].length - 1] + "], m: " + m[i]);
            System.out.print("\tnums2: [");
            for (int j = 0; j < nums2[i].length - 1; j++) {
                System.out.print(nums2[i][j] + ", ");
            }
            System.out.println(nums2[i][nums2[i].length - 1] + "], n: " + n[i]);
            System.out.println("\tMerged list:" + Arrays.toString(mergeSortedArray(nums1[i], m[i], nums2[i], n[i])));
            //System.out.println(PrintHyphens.repeat("-", 100));
            k += 1;
        }
    }
}
