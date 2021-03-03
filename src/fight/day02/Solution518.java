package fight.day02;

import org.junit.jupiter.api.Test;

/**
 * 零钱兑换
 */
public class Solution518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            int sum = coin;
            while (sum <= amount) {
                for (int i = 0; i < amount + 1; i++) {
                    if (i + sum <= amount) {
                        dp[i + sum]++;
                    } else {
                        break;
                    }
                }
                sum += coin;
            }
        }
        return dp[amount];
    }

    @Test
    public void test() {
        int[] ints = {1, 2, 5};
        int change = change(5, ints);
        System.out.println(change);
    }
}
