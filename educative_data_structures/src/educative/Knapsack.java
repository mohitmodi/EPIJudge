package educative;

public class Knapsack {
    //capacity=30
    //weights=10,20,30
    //values=22,33,44
    //output=55

    public static int knapsack(int[] values, int[] weights, int maxWeightConstraint) {

        int dp[][] = new int[values.length + 1][maxWeightConstraint + 1];
        //base case when we have no weights to choose from and when we have no weihgt to weigh
        for (int i = 0; i <= weights.length; i++) {
            for (int j = 0; j <= maxWeightConstraint; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;//base case
                } else if (weights[i - 1] > j) {//we cant add if weight of current item is greater than maxWeight allowed
                    dp[i][j] = dp[i - 1][j];//we cant choose meaning go 1 row above on same column
                } else {
                    //if we can choose we check if by choosing we get  max value or by not choosing
                    int withItem = values[i - 1] + dp[i - 1][j - weights[i - 1]];
                    int withoutItem = dp[i - 1][j];
                    dp[i][j] = Math.max(withoutItem, withItem);
                }

            }
        }
        return dp[values.length][maxWeightConstraint];
    }

    public static void main(String[] args) {
        int[] values = new int[]{22, 33, 44};
        int[] weights = new int[]{10, 20, 30};
        int maxWeightConstraint = 30;
        System.out.println(knapsack(values, weights, maxWeightConstraint));
    }
}
