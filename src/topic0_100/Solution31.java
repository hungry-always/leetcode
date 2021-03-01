package topic0_100;

import java.util.Arrays;

/**
 * 下一个排序
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                int minIndex = getMinIndex(nums, nums[i - 1], i, n - 1);
                swap(nums, minIndex, i - 1);
                Arrays.sort(nums, i, n);
                return;
            }
        }
        Arrays.sort(nums);
    }

    private int getMinIndex(int[] nums, int num, int start, int end) {
        int min = start;
        for (int i = start; i < nums.length; i++) {
            if (num < nums[i] && nums[i] < nums[min]) {
                min = i;
            }
        }
        return min;
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
