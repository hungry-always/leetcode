package interview;

import org.junit.jupiter.api.Test;

/**
 * 石子游戏VII
 */
public class Solution1690 {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = ((i + j) % 2 != 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (i % 2 != 0) {
                    dp[j][i - j] = Math.min(dp[j][i - j], stones[n - (i - j)] - dp[j][i - j - 1]);
                    dp[i - j][j] = Math.min(dp[i - j][j], stones[i - j - 1] - dp[i - j - 1][j]);
                } else {
                    dp[j][i - j] = Math.max(dp[j][i - j], stones[n - (i - j)] + dp[j][i - j - 1]);
                    dp[i - j][j] = Math.max(dp[i - j][j], stones[i - j - 1] + dp[i - j - 1][j]);
                }
            }
        }
        return 0;
    }

    @Test
    public void test() {
        int[] ints = {5, 3, 1, 4, 2};
        int i = stoneGameVII(ints);
    }
}
