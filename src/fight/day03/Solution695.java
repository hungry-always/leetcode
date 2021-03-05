package fight.day03;

public class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] dp = new boolean[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(grid, dp, 0, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] grid, boolean[][] dp, int sum, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && !dp[i][j]) {
            dp[i][j] = true;
            sum++;
            sum = dfs(grid, dp, sum, i + 1, j);
            sum = dfs(grid, dp, sum, i - 1, j);
            sum = dfs(grid, dp, sum, i, j - 1);
            sum = dfs(grid, dp, sum, i, j + 1);
        }
        return sum;
    }

}
