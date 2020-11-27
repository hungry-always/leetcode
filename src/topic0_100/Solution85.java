package topic0_100;

import org.junit.jupiter.api.Test;

/**
 * 最大矩形
 */
public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
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

    @Test
    public void test() {
        char[][] chars = {new char[]{'0', '1', '0'}, new char[]{'0', '1', '0'}};
        System.out.println(maximalRectangle(chars));
    }
}
