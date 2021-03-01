package everyDay.date_2021.Mar;

import org.junit.jupiter.api.Test;

/**
 * 区域和检索-数组不可变
 */
public class Solution3_01 {
    @Test
    public void test() {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        int i = numArray.sumRange(2, 5);
        System.out.println(i);
    }
}

class NumArray {
    int[] sums;
    int[] Arr;

    public NumArray(int[] nums) {
        Arr = nums;
        sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return sums[j] - (i == 0 ? 0 : sums[i - 1]);
    }
}
