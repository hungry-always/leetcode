package topic101_200;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        dp[m - 1][n] = dp[m][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(min - dungeon[i][j], 1);
//                dp[i][j] = min - dungeon[i][j];
            }
        }
        return dp[0][0];
    }

    @Test
    public void test() {
        int[][] ints = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int i = calculateMinimumHP(ints);
        System.out.println(i);
    }
}
