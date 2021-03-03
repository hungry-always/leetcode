package fight.day02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int num : nums) {
            int start = 0;
            int end = n - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                int midNum = dp[mid];
                if (midNum > num) {
                    int min = mid - 1 == -1 ? Integer.MIN_VALUE : dp[mid - 1];
                    if (min < num) {
                        dp[mid] = num;
                        break;
                    }else{
                        end = mid-1;
                    }
                } else {
                    start = mid + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                return i;
            }
        }
        return n;
    }

    @Test
    public void test() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }
}
