package everyWeek.usual.s2;

import org.junit.jupiter.api.Test;

public class Solution3 {
    public int stoneGameVII(int[] stones) {
        int count = 0;
        int start = 0;
        int end = stones.length - 1;
        while (start < end) {
            if (Math.min(stones[start + 1], stones[end]) < Math.min(stones[start], stones[end - 1])) {
                end--;
                if (stones[end] < stones[start]) {
                    count += stones[end];
                    end--;
                } else {
                    count += stones[start];
                    start++;
                }
            } else {
                start++;
                if (stones[start] > stones[end]) {
                    count += stones[end];
                    end--;
                } else {
                    count += stones[start];
                    start++;
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[] nums = {5,3,1,4,2};
        int i = stoneGameVII(nums);
        System.out.println(i);
    }
}
