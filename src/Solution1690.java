import org.junit.jupiter.api.Test;

public class Solution1690 {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (i % 2 != 0) {
                dp[0][i] = dp[0][i - 1] + stones[i - 1];
                dp[i][0] = dp[i - 1][0] + stones[n - i];
            } else {
                dp[0][i] = dp[0][i - 1] - stones[i - 1];
                dp[i][0] = dp[i - 1][0] - stones[n - i];
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1 - i; j++) {
                if (i + j % 2 == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j] - stones[i - 1], dp[i][j - 1] - stones[n - j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j] + stones[i - 1], dp[i][j - 1] + stones[n - j]);
                }
            }
        }

        return 0;
    }

    @Test
    public void test() {
        int[] nums = {5, 3, 1, 4, 2};
        int i = stoneGameVII(nums);
        System.out.println(i);
    }
}
