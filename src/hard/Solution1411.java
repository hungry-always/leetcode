package hard;

import org.junit.jupiter.api.Test;

public class Solution1411 {
    public int numOfWays(int n) {
        final long a = 1000_000_007;
        long[][] dp = new long[n][2];
        dp[0][0] = 6;
        dp[0][1] = 6;
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][0] * 3 + dp[i - 1][1] * 2) % a;
            dp[i][1] = (dp[i - 1][0] * 2 + dp[i - 1][1] * 2) % a;
        }
        int i = (int) ((dp[n - 1][0] + dp[n - 1][1])%a);
        return i;
    }

    @Test
    public void test() {
        System.out.println(numOfWays(5000));
        System.out.println(Integer.MAX_VALUE);
    }
}
