package everyWeek.s11;

import org.junit.jupiter.api.Test;

public class Solution01 {
    public boolean check(int[] nums) {
        boolean flag1 = false;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (!flag1) {
                    flag1 = true;
                } else {
                    return false;
                }
            }
        }
        if (flag1) {
            return nums[nums.length - 1] <= nums[0];
        } else {
            return true;
        }
    }

    @Test
    public void test() {
        boolean check = check(new int[]{1,2,3});
        System.out.println(check);
    }
}
