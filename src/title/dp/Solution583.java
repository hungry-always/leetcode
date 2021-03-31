package title.dp;

import org.junit.jupiter.api.Test;

/**
 * 583. 两个字符串的删除操作
 */
public class Solution583 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int min = Math.min(dp[i + 1][j] + 1, dp[i][j + 1] + 1);
                if (word1.charAt(i) == word2.charAt(j)) {
                    min = Math.min(min, dp[i][j]);
                }
                dp[i + 1][j + 1] = min;
            }
        }
        return dp[n][m];
    }

    @Test
    public void test() {
        int i = minDistance("sea", "eat");
        System.out.println(i);
    }
}
