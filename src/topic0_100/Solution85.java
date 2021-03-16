package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 最大矩形
 */
public class Solution85 {
    // 使用动态规划，暴力法
    public int maximalRectangle2(char[][] matrix) {
        int length = matrix.length;
        if (length == 0) {
            return 0;
        }
        int width = matrix[0].length;
        int[][] dp = new int[length][width];
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int j = 0; j < width; j++) {
                count = matrix[i][j] == '1' ? count + 1 : 0;
                dp[i][j] = count;
            }
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int count = dp[i][j];
                int maxArea = count;
                if (count != 0) {
                    for (int k = i; k >= 0; k--) {
                        int dpCount = dp[k][j];
                        if (dpCount != 0) {
                            count = Math.min(count, dpCount);
                            maxArea = Math.max(count * (i - k + 1), maxArea);
                        } else {
                            break;
                        }
                    }
                }
                result = Math.max(result, maxArea);
            }
        }
        return result;
    }

    // 最小值栈
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (matrix[j - 1][i] == '1') {
                    dp[j][i] = dp[j - 1][i] + 1;
                }
            }
        }
        int max = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i < m + 1; i++) {
            Arrays.fill(left, 0);
            Arrays.fill(right, n);
            stack.clear();
            for (int j = 0; j < n; j++) {
                int num = dp[i][j];
                while (!stack.isEmpty() && dp[i][stack.peek()] >= num) {
                    right[stack.pop()] = j;
                }
                left[j] = (stack.isEmpty()) ? -1 : stack.peek();
                stack.push(j);
            }
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j] * (right[j] - left[j] - 1));
            }
        }
        return max;
    }

    @Test
    public void test() {
        char[][] chars = {new char[]{'0', '1', '0'}, new char[]{'0', '1', '0'}};
        System.out.println(maximalRectangle(chars));
    }
}
