package topic0_100;

import org.junit.jupiter.api.Test;

public class Solution80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int dupCount = 1;
        int dupNum = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == dupNum) {
                if (dupCount < 2) {
                    dupCount++;
                    nums[count++] = num;
                }
                dupCount++;
            } else {
                dupNum = num;
                dupCount = 1;
                nums[count++] = num;
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
    }
}
