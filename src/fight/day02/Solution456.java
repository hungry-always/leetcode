package fight.day02;

import java.util.Stack;

public class Solution456 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] minArr = new int[n];
        minArr[0] = nums[0];
        for (int i = 1; i < n; i++) {
            minArr[i] = Math.min(minArr[i - 1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 1; i--) {
            while (!stack.isEmpty()) {
                Integer peek = stack.peek();
                if (peek > minArr[i - 1]) {
                    if (peek < nums[i]) {
                        return true;
                    } else {
                        break;
                    }
                }
                stack.pop();
            }
            stack.add(nums[i]);
        }
        return false;
    }
}
