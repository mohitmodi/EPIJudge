package educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfTwoSortedArrays {
    public static double findMedian(int nums1[], int nums2[]) {
        int i = 0;
        int j = 0;
        double median = 0.0;
        List<Integer> result = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                result.add(nums1[i]);
                i++;
            } else {
                result.add(nums2[j]);
                j++;
            }
        }
        while (i < nums1.length) {
            result.add(nums1[i]);
            i++;
        }
        while (j < nums2.length) {
            result.add(nums2[j]);
            j++;
        }
        System.out.println(Arrays.toString(result.toArray()));
        System.out.println(result.size());
        int mid = result.size() / 2;
        if (result.size() % 2 == 0) {
            median = (result.get(mid-1) + result.get(mid)) / 2.0;
        } else {
            median = result.get(mid);
        }
        return median;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{5,7,8,13,17,22,29};
        int nums2[] = new int[]{30,32,39,41};
        System.out.println(findMedian(nums1, nums2));
    }
}
