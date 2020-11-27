package topic0_100;

import org.junit.jupiter.api.Test;

public class Solution96 {
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        return numTrees(n, dp);
    }

    private int numTrees(int n, int[] dp) {
        int num = dp[n];
        if (num != 0) {
            return num;
        }
        for (int i = 0; i < n; i++) {
            int i1 = numTrees(i, dp);
            int i2 = numTrees(n - 1 - i, dp);
            num += (i1 * i2);
        }
        dp[n] = num;
        return num;
    }

    @Test
    public void test() {
        System.out.println(numTrees(3));
    }
}
