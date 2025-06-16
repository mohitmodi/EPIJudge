package educative;


// -2 1 -3 4 -1 2 1 -5 4
public class MaxSubArraySum {
    public static int maxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                currSum += arr[j];
                maxSum = Math.max(currSum, maxSum);
            }
            currSum = 0;
        }
        return maxSum;
    }

    public static int maxSum2(int[] arr) {
        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        int maxSum = dp[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, 5, 4};
        System.out.println(maxSum(arr));
        System.out.println(maxSum2(arr));
    }
}
