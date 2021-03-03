package fight.day02;

import java.util.Stack;

public class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<int[]> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            int num = T[i];
            while (!stack.isEmpty() && stack.peek()[1] <= num) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                T[i] = 0;
                stack.add(new int[]{i, num});
            } else {
                T[i] = stack.peek()[0]-i;
            }
        }
        return T;
    }
}
