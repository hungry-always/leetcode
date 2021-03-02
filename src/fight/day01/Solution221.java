package fight.day01;

import commmon.ArraysUtils;
import org.junit.jupiter.api.Test;

public class Solution221 {
    public int maximalSquare(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        A[][] dp = new A[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = new A();
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    dp[i][j].length = dp[i - 1][j].length + 1;
                    dp[i][j].width = dp[i][j - 1].width + 1;
                    dp[i][j].areaLength = getMin(dp[i - 1][j - 1].areaLength + 1, dp[i][j].width, dp[i][j].length);
                }
            }
        }
        int max = 0;
        for (A[] as : dp) {
            for (A a : as) {
                int max1 = a.areaLength;
                max = Math.max(max1 * max1, max);
            }
        }
        return max;
    }

    int getMin(int... ints) {
        int anInt = ints[0];
        for (int i : ints) {
            if (i < anInt) {
                anInt = i;
            }
        }
        return anInt;
    }

    class A {
        int width;
        int length;
        int areaLength;

        public A() {
            this.width = 0;
            this.length = 0;
            areaLength = 0;
        }
    }

    @Test
    public void test() {
        int[][] ints = ArraysUtils.generateTwo("[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]\n");
        int i = maximalSquare(ints);
        System.out.println(i);
    }
}
