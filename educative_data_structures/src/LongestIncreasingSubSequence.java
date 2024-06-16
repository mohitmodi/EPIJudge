import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubSequence {

    public static int longestCommonSubsequence(int[] arr) {
        int dp[] = new int[arr.length + 1];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] >= arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        StringBuilder s=new StringBuilder();


        return max;

    }

    public static void main(String[] args) {
        int[] arr = {9809, 931, 8830, 3358, 2964, 7604, 2447, 489, 5941, 9925, 1922, 2243, 1420, 4448, 882, 9812, 7516, 4850, 2723, 4665, 3502, 9037, 1704, 2131, 9440, 4730, 3630, 2603, 4632, 3616, 4621, 793, 4547, 3452, 503, 7511, 7408, 9302, 4352, 9701, 9227, 2626, 1944, 648, 7075, 2826, 460, 4591, 4029, 9535, 5609, 3883, 8572, 3665, 6014, 4365, 8395, 9644, 6968, 3027, 3260, 1589, 172, 4159, 1393, 676, 1671, 5153, 9978, 2375, 4855, 5558, 5002, 6799, 6206, 2077, 5978, 3018, 3020, 6359, 2553, 8629, 242, 7477, 8646, 6257, 1842, 7042, 5901, 5162, 6421, 5514, 6752, 6594, 9673, 4497, 3622, 7696, 9651, 9952};
        System.out.println(longestCommonSubsequence(arr));
    }

    public static int lcs(String s1, String s2, int i, int j, int[][] dp) {
        if (i == 0 || j == 0) {
            return 0;
        }
        /*if (dp[i-1][j-1] != null) {
            return dp[i - 1][j - 1];
        } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            dp[i - 1][j - 1] = 1 + lcs(s1, s2, i - 1, j - 1, dp);
        } else {
            dp[i - 1][j - 1] = Math.max(lcs(s1, s2, i - 1, j, dp), lcs(s1, s2, i, j - 1, dp));
        }*/

        return dp[i - 1][j - 1];
    }

    public static int lcs2(String s1, String s2, int i, int j, int[][] dp) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        } else if (dp[i][j] == -1) {
            if (s1.charAt(i) == s2.charAt(j)) {
                dp[i][j] = 1 + lcs(s1, s2, i - 1, j - 1, dp);
            } else {
                dp[i][j] = Math.max(lcs(s1, s2, i - 1, j, dp), lcs(s1, s2, i, j - 1, dp));
            }
        }

        return dp[i][j];
    }

}
