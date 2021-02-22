package generalize.dp;

import org.junit.jupiter.api.Test;

/**
 * 最长回文子序列
 */
public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j <= n - 1; j++) {
                if (j == i) {
                    dp[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }

    @Test
    public void test() {
        int bbbab = longestPalindromeSubseq("bcabd");
        System.out.println(bbbab);

    }
}
