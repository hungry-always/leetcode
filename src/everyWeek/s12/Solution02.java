package everyWeek.s12;

import org.junit.jupiter.api.Test;

public class Solution02 {
    public boolean canChoose(int[][] groups, int[] nums) {
        int index = 0;
        for (int[] group : groups) {
            boolean isStart = false;
            int start = index;
            int i = 0;
            while (i <= group.length - 1) {
                if (index > nums.length - 1) {
                    return false;
                }
                if (nums[index] == group[i]) {
                    if (!isStart) {
                        start = index;
                    }
                    i++;
                    isStart = true;
                } else {
                    if (isStart) {
                        i = 0;
                        index = start;
                        isStart = false;
                    }
                }
                index++;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[][] groups = {{1, -1, -1}, {3, -2, 0}};
        int[] nums = {1, -1, 0, 1, -1, -1, 3, -2, 0};
        boolean b = canChoose(groups, nums);
        System.out.println(b);
    }
}
