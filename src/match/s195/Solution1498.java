package match.s195;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution1498 {
    final long mod = (long) (10e8 + 7);
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int n = nums.length;
        int right = n - 1;
        long count = 0;
        long[] pow = new long[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                count += pow[right - left];
                count %= mod;
                left++;
            } else {
                right--;
            }
        }
        return (int) count;
    }

    @Test
    public void test() {
        System.out.println(mod);
    }
}
