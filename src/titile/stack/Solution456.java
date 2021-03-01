package titile.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 123模式
 */
public class Solution456 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MAX_VALUE;
        int[] minArr = new int[n];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            minArr[i] = min;
        }
        int start = 0, mid = n - 2, end = n - 1;
        while (start >= 0) {
        }
        return false;
    }

    @Test
    public void test() {
        boolean pattern = find132pattern(new int[]{-1, 3, 2, 0});
        System.out.println(pattern);
    }
}
