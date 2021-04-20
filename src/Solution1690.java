import org.junit.jupiter.api.Test;

public class Solution1690 {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            dp[0][i] = i % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                boolean isMax = ((i + j) % 2 == 1);
                if (isMax) {
                    dp[i][j] = Math.max(dp[i - 1][j] + stones[i - 1], dp[i][j - 2] + stones[n + 1 - j]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] - stones[i - 1], dp[i][j - 2] - stones[n + 1 - j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n + 2; i++) {
            min = Math.min(dp[i][n + 2 - i], min);
        }
        return min;
    }

    @Test
    public void test() {
        int[] nums = {5, 3, 1, 4, 2};
        int i = stoneGameVII(nums);
        System.out.println(i);
    }
}
