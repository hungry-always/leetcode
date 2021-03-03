package fight.day02;

import java.util.Arrays;

/**
 * 零钱兑换II
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int coin : coins) {
            dp[coin - 1] = 1;
        }
        for (int i = 0; i < amount; i++) {
            if (dp[amount] != Integer.MAX_VALUE) {
                for (int coin : coins) {
                    if (coin + i <= amount - 1) {
                        dp[coin + i] = Math.min(dp[coin + i], dp[amount] + 1);
                    }
                }
            }
        }
        return dp[amount - 1];
    }
}
