package topic101_200;

import org.junit.jupiter.api.Test;

public class Solution189 {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        int count = 0;
        for (int start = 0; count < length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int nextIndex = (current + k) % length;
                int temp = nums[nextIndex];
                nums[nextIndex] = prev;
                prev = temp;
                current = nextIndex;
                count++;
            } while (start != current);
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums,3);
        System.out.println("=========");
    }
}
