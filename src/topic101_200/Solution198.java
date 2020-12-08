package topic101_200;

import org.junit.jupiter.api.Test;

/**
 * 打家劫舍
 */
public class Solution198 {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            switch (i) {
                case 0:
                    dp[i] = num;
                    break;
                case 1:
                    dp[i] = Math.max(nums[0], num);
                    break;
                default:
                    dp[i] = Math.max(num + dp[i - 2], dp[i - 1]);
            }
        }
        return dp[length - 1];
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }
}
