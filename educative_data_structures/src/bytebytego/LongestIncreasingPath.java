package bytebytego;

import java.util.List;

public class LongestIncreasingPath {
    public int longestIncreasingPath(List<List<Integer>> matrix) {
        if (matrix == null || matrix.isEmpty()) {
            return 0;
        }

        int m = matrix.size(), n = matrix.get(0).size();
        int[][] memo = new int[m][n];
        int res = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                res = Math.max(res, dfs(matrix, memo, r, c, m, n));
            }
        }

        return res;
    }

    private int dfs(List<List<Integer>> matrix, int[][] memo, int r, int c, int m, int n) {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }

        int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int maxLen = 1;

        for (int[] dir : direction) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix.get(nr).get(nc) > matrix.get(r).get(c)) {
                maxLen = Math.max(maxLen, 1 + dfs(matrix, memo, nr, nc, m, n));
            }
        }

        memo[r][c] = maxLen;
        return maxLen;
    }
}