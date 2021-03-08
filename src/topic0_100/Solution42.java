package topic0_100;

import java.util.Stack;

public class Solution42 {
    public int trap(int[] height) {
        int count = 0;
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = height[0];
        stack.add(0);
        for (int i = 1; i < height.length; i++) {
            int num = height[i];
            while (!stack.isEmpty() && height[stack.peek()] <= num) {
                Integer pop = stack.pop();
                int width = i - pop;
                count += (Math.min(max, num) - height[pop]) * width;
            }
            max = Math.max(max, num);
            stack.add(num);
        }
        return count;
    }
}
