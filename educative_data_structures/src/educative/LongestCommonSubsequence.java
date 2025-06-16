package educative;

import java.sql.SQLOutput;
import java.util.Arrays;

public class LongestCommonSubsequence {
    public static int lcs(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < s1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                System.out.println("i" + s1.charAt(i-1));
                System.out.println("j" + s2.charAt(j-1));
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "found";
        String s2 = "cloud";
        System.out.println(lcs(s1, s2));
    }
}
