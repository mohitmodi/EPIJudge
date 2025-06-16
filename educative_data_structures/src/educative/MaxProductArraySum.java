package educative;


// -2 1 -3 4 -1 2 1 -5 4
public class MaxProductArraySum {
    public static int maxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                currSum *= arr[j];
                maxSum = Math.max(currSum, maxSum);
            }
            currSum = 1;
        }
        return maxSum;
    }

    public static int maxSum2(int[] arr) {
        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        int minSoFar = arr[0];
        int maxProduct = dp[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(arr[i], Math.max(arr[i] * dp[i - 1], arr[i] * minSoFar));
            minSoFar = Math.min(arr[i], Math.min(arr[i] * dp[i - 1], arr[i] * minSoFar));
            maxProduct = Math.max(maxProduct, dp[i]);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, -5, 3, 1, -4, 0, -10, 2};
        System.out.println(maxSum(arr));
        System.out.println(maxSum2(arr));
    }
}
