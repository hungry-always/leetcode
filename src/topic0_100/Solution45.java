package topic0_100;

import org.junit.jupiter.api.Test;

public class Solution45 {
    public int jump(int[] nums) {
        int start = 0, end = 0, count = 0;
        while (true) {
            if (end >= nums.length - 1) {
                break;
            }
            int max = end;
            for (int i = start; i <= end; i++) {
                max = Math.max(i + nums[i], max);
            }
            start = end + 1;
            end = max;
            count++;
        }
        return count;
    }

    @Test
    public void test() {
        int jump = jump(new int[]{2,3,1,1,1,2,3,2,3,23,2,1,2,3,2,1,1,3,4,5,4});
        System.out.println(jump);
    }
}
