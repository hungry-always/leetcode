package topic0_100;

import org.junit.jupiter.api.Test;

/**
 * 缺失的第一个正数
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] <= 0) {
                nums[i] = length + 1;
            }
        }
        for (int i = 0; i < length; i++) {
            int abs = Math.abs(nums[i]);
            if (abs <= length) {
                nums[abs - 1] = -Math.abs(nums[abs - 1]);
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;
    }

    @Test
    public void test() {
        System.out.println(firstMissingPositive(new int[]{1,1}));
    }
}
