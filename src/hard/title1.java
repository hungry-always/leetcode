package hard;

/**
 * 深度优先搜索
 */
public class title1 {
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = dfs(matrix, dp, i, j);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int[][] dp, int i, int j) {
        // 如果改点已经搜索过了，就直接返回
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        dp[i][j] = 1;
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            // i,j不越界，并且值大于matrix[i][j]，取最大值
            if (newI >= 0 && newI <= matrix.length - 1 && newJ >= 0 && newJ <= matrix[0].length - 1 && matrix[newI][newJ] > matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j], 1 + dfs(matrix, dp, newI, newJ));
            }
        }
        return dp[i][j];
    }
}
