package arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArrraysSumsTok {
    public static int countSubarrays(int[] arr, int k) {
        int[] sums = new int[arr.length];
        sums[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sums[i] = sums[i - 1] + arr[i];
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int currSum = sums[j];
                if (i != 0)
                    currSum -= sums[i - 1];
                if (currSum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countSubarrays2(int[] arr, int k) {

        Map<Integer, Integer> sums = new HashMap<>();
        int count = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sums.containsKey(sum - k))
                count += sums.get(sum - k);
            if (sums.containsKey(sum)) {
                sums.put(sum, sums.get(sum) + 1);
            } else {
                sums.put(sum, 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] input = {1, 0, -1, 1};
        System.out.println(countSubarrays(input, 0));
    }
}
