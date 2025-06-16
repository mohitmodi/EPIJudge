package educative;

import java.util.Arrays;

//2 3 1 2 4 3
//7
public class MinimumSizeSubArraySum {

    public static int minSubArrayLen(int target, int[] nums) {

        int start = 0;
        int currSum = 0;
        int minLength = Integer.MAX_VALUE;
        for(int end=0;end<nums.length;end++) {
            if (currSum < target) {
                currSum += nums[end];
            }
                while (currSum >= target) {
                    minLength = Math.min(minLength, end - start+1);
                    currSum = currSum - nums[start];
                    start++;
                }
            }
        if(minLength==Integer.MAX_VALUE){
            return 0;
        }
        return minLength;
    }
    public static void main(String[] args) {
        int[] target = {7, 4, 11, 10, 5, 15};
        int[][] inputArr = {
                {2, 3, 1, 2, 4, 3},
                {1, 4, 4},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 2, 3, 4},
                {1, 2, 1, 3},
                {5, 4, 9, 8, 11, 3, 7, 12, 15, 44}
        };
        for (int i = 0; i < target.length; i++) {
            int windowSize = minSubArrayLen(target[i], inputArr[i]);
            System.out.print((i + 1) + ".\tInput array: " + Arrays.toString(inputArr[i]));
            System.out.print("\n\tTarget: " + target[i]);
            System.out.println("\n\tMinimum Length of Subarray: " + windowSize);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
