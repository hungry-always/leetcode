package topic0_100;

public class Solution64 {
    public int minPathSum(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (i != 0 && j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else if (i != 0 && j != 0) {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[length - 1][width - 1];
    }
}
