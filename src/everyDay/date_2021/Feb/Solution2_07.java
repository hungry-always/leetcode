package everyDay.date_2021.Feb;

import org.junit.jupiter.api.Test;

public class Solution2_07 {
    public boolean checkPossibility(int[] nums) {
        int min = Integer.MIN_VALUE;
        boolean flag = false;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num < min) {
                if (flag) {
                    return false;
                } else {
                    int start = (i - 2 >= 0) ? nums[i - 2] : Integer.MIN_VALUE;
                    int end = (i + 1 <= length - 1) ? nums[i + 1] : Integer.MAX_VALUE;
                    if ((num >= start && num <= end) || (nums[i - 1] >= start && nums[i - 1] <= end)) {
                        flag = true;
                        min = Math.min(num, nums[i - 1]);
                    } else {
                        return false;
                    }
                }
            }
            min = num;
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(checkPossibility(new int[]{3,4, 2, 3}));
        System.out.println(checkPossibility(new int[]{5,7,1,8}));
    }
}
