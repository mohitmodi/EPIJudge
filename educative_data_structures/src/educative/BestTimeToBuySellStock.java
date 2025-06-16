package educative;


//7 1 5 3 6 4

import java.util.Arrays;

public class BestTimeToBuySellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        int[] dp = new int[prices.length];
        int maxProfit = prices[1] - prices[0];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            int profitDelta = prices[i] - prices[i - 1];
            dp[i] = Math.max(0, profitDelta + dp[i - 1]);
            maxProfit = Math.max(dp[i], maxProfit);
        }
        System.out.println(Arrays.toString(dp));
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 6, 8, 7, 8, 7, 9, 4, 1, 2, 4, 5, 8};
        System.out.println(maxProfit(input));
    }
}
