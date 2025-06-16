package grind88;

public class BuySellStockOnce {
    public static void main(String[] args) {
        int arr[] = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

    private static int maxProfit(int[] arr) {
        int maxProfit = 0;
        int minBuyprice = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minBuyprice) {
                minBuyprice = arr[i];
            }
            if (maxProfit < arr[i] - minBuyprice) {
                maxProfit = arr[i] - minBuyprice;
            }

        }
        return maxProfit;
    }

    private static int maxProfitDp(int[] arr) {
        int maxProfit = 0;
        int dp[] = new int[arr.length];
        dp[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            int profit = arr[i] - arr[i - 1];
            dp[i] = Math.max(0, profit + dp[i - 1]);
            maxProfit = Math.max(maxProfit, dp[i]);

        }
        return maxProfit;
    }
}
