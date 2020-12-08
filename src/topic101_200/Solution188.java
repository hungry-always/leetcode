package topic101_200;

import org.junit.jupiter.api.Test;

public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if (k <= 0 || length <= 1) {
            return 0;
        }
        // 1表示股票在手，0表示股票不在手
        int[][][] dp = new int[2][k][length];
        for (int i = 0; i < k; i++) {
            dp[1][i][0] = -prices[0];
            if (i == 0) {
                for (int j = 1; j < length; j++) {
                    dp[1][0][j] = Math.max(dp[1][0][j - 1], -prices[j]);
                    dp[0][0][j] = Math.max(dp[0][0][j - 1], dp[1][0][j - 1] + prices[j]);
                }
            } else {
                for (int j = 1; j < length; j++) {
                    dp[1][i][j] = Math.max(dp[0][i - 1][j - 1] - prices[j], dp[1][i][j - 1]);
                    dp[0][i][j] = Math.max(dp[0][i][j - 1], dp[1][i][j - 1] + prices[j]);
                }
            }
        }
        return dp[0][k - 1][length - 1];
    }

    @Test
    public void test() {
        int[] nums = {1,2};
        System.out.println(maxProfit(1, nums));
    }
}
