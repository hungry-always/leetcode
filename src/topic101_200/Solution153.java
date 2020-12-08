package topic101_200;

import org.junit.jupiter.api.Test;

public class Solution153 {
    public int findMin(int[] nums) {
        int length = nums.length;
        int num = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] < num) {
                return nums[i];
            } else {
                num = nums[i];
            }
        }
        return nums[0];
    }

    @Test
    public void test() {
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
