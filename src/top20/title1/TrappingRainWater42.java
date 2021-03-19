package top20.title1;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

public class TrappingRainWater42 {
    // 动态编程
    public int trap1(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = Math.max(height[i], (i - 1 >= 0) ? Integer.MIN_VALUE : left[i - 1]);
        }
        for (int i = n - 1; i >= 0; i--) {
            right[i] = Math.max(height[i], (i + 1 < n) ? Integer.MIN_VALUE : right[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (Math.min(left[i], right[i]) - height[i]);
        }
        return sum;
    }

    public int trap2(int[] height) {
        /**
         * 栈
         */
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = height.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                Integer poll = stack.poll();
                if (!stack.isEmpty()) {
                    // 出栈的时候，如果栈中还有元素，说明可以包裹，所以填上空缺
                    sum += (Math.min(height[i], height[stack.peek()]) - height[poll]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return sum;
    }

    // 双指针
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int sum = 0;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            if (maxLeft > maxRight) {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else if (height[right] < maxLeft) {
                    sum += (maxRight - height[right]);
                }
                right--;
            } else {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else if (height[left] < maxRight) {
                    sum += (maxLeft - height[left]);
                }
                left++;
            }
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));// 6
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));// 9
    }
}
