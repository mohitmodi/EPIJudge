package exponent;

public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 3, 1, 4, 2, 1, 8};
        System.out.println(robber(arr));
    }

    private static int robber(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[1], arr[0]);

        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
        }
        return dp[arr.length - 1];
    }
}
