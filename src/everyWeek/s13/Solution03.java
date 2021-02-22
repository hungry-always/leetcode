package everyWeek.s13;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 执行乘法运算的最大分数
 */
public class Solution03 {
    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        int n = nums.length;
        // 前面定义为列，后面定义为行
        int[][] dp = new int[m + 1][m + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints,Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        for (int k = 1; k <= m; k++) {
            for (int i = 0; i < k; i++) {
                int j = k - i - 1;
                dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j] + multipliers[i + j] * nums[n - 1 - j]);
                dp[i + 1][j] = Math.max(dp[i][j] + multipliers[i + j] * nums[i], dp[i + 1][j]);
            }
        }
        int max = 0;
        for (int i = 0; i <= m; i++) {
            max = Math.max(dp[i][m - i], max);
        }
        return max;
    }

    @Test
    public void test() {
        int[] nums1 = {555, -434, -947, 968, -250};
        int[] multipliers1 = {783, 911, 286, -74, -899};
        int i = maximumScore(nums1, multipliers1);
        System.out.println(i);
    }
}
