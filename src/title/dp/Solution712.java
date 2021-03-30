package title.dp;

import org.junit.jupiter.api.Test;

public class Solution712 {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = s1.charAt(i-1) + dp[i - 1][0];
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i] = s2.charAt(i-1) + dp[0][i - 1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int min = Math.min(dp[i + 1][j] + s2.charAt(j), dp[i][j + 1] + s1.charAt(i));
                if (s1.charAt(i) == s2.charAt(j)) {
                    min = Math.min(min, dp[i][j]);
                }
                dp[i + 1][j + 1] = min;
            }
        }
        return dp[n][m];
    }

    @Test
    public void test() {
        System.out.println(minimumDeleteSum("sea", "eat"));
        System.out.println(minimumDeleteSum("delete", "leet"));
    }
}
