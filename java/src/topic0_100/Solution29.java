package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Solution29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isMoreZero = true;
        if ((dividend < 0) ^ (divisor < 0)) {
            isMoreZero = false;
        }
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        int result = 0;
        int count = 1;
        int different = divisor;
        Stack<int[]> stack = new Stack<>();
        while (different >= dividend) {
            stack.push(new int[]{count, different});
            if (different < Integer.MIN_VALUE / 2) {
                break;
            }
            different += different;
            count += count;
        }
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            if (dividend <= pop[1]) {
                dividend -= pop[1];
                result += pop[0];
            }
            if (dividend <= pop[1]) {
                dividend -= pop[1];
                result += pop[0];
            }
        }
        return isMoreZero ? result : -result;
    }

    @Test
    public void test() {
        System.out.println(divide(10, 3));
//        System.out.println(Integer.MAX_VALUE);// 2147483647
    }
}
