package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= height) {
                right[stack.pop()] = i;
            }
            left[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }
        return max;
    }

    @Test
    public void test() {
        int[] ints = {12, 31, 223, 123};
        int i = largestRectangleArea(ints);
        System.out.println(i);
    }
}
