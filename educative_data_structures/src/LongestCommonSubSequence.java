import java.util.Arrays;

public class LongestCommonSubSequence {

    public static String longestCommonSubsequence(String str1, String str2) {
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < str1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < str2.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = str1.length();
        int j = str2.length();
        int longestSubsequenceSize = dp[str1.length()][str2.length()];
        char[] longest = new char[longestSubsequenceSize];

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                longest[longestSubsequenceSize - 1] = str1.charAt(i-1);
                i--;
                j--;
                longestSubsequenceSize--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else j--;
        }


        return Arrays.toString(longest);

    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("partner", "park"));
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
