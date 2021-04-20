import commmon.ArraysUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution1727 {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = (i == 0) ? 1 : matrix[i - 1][j] + 1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            Arrays.sort(matrix[i]);
            for (int j = n - 1; j >= 0; j--) {
                result = Math.max(result, (n - j) * matrix[i][j]);
            }
        }
        return result;
    }

    @Test
    public void test() {
//        int[][] ints = ArraysUtils.generateTwo("[[0,0,1],[1,1,1],[1,0,1]]");
        int[][] ints = ArraysUtils.generateTwo("[[1,0,1,0,1]]");
        int i = largestSubmatrix(ints);
        System.out.println(i);
    }
}
