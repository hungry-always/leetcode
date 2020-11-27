package topic0_100;

import org.junit.jupiter.api.Test;

public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int length = obstacleGrid[0].length;
        int width = obstacleGrid.length;
        int[][] dp = new int[width][length];
        for (int i = 0; i < width; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < length; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < width; i++) {
            for (int j = 1; j < length; j++) {
                dp[i][j] = (obstacleGrid[i][j] == 1) ? 0 : (dp[i - 1][j] + dp[i][j - 1]);
            }
        }
        return dp[width - 1][length - 1];
    }

    @Test
    public void test() {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0}}));
    }
}
