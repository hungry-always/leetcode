package titile.stack;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 好子数组的最大分数
 */
public class Solution1793 {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            left[i] = (stack.isEmpty()) ? 0 : stack.peek() + 1;
            if (stack.isEmpty() || nums[stack.peek()] < nums[i]) {
                stack.push(i);
            }
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty()) ? n - 1 : stack.peek() - 1;
            if (stack.isEmpty() || nums[stack.peek()] < nums[i]) {
                stack.push(i);
            }
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left[i] <= k && right[i] >= k) {
                max = Math.max(nums[i] * (right[i] - left[i] + 1), max);
            }
        }
        return max;
    }

    @Test
    public void test() {
        int[] ints = {5,5,4,5,4,1,1,1};
        int i = maximumScore(ints, 0);
        System.out.println(i);
    }
}
