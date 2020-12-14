package everyWeek.s1;

import org.junit.jupiter.api.Test;

public class Solution2 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] result = new int[nums.length];
        int num = nums[0];
        for (int i : nums) {
            result[0] += Math.abs(i - num);
        }
        for (int i = 1; i < result.length; i++) {
            int i1 = nums[i] - nums[i - 1];
            result[i] = result[i - 1] - i1 * ((result.length - i) - i);
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = {2, 3, 5};
        int[] sumAbsoluteDifferences = getSumAbsoluteDifferences(nums);
        System.out.println(sumAbsoluteDifferences);
    }
}
