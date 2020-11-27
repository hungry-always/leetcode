package topic0_100;

import org.junit.jupiter.api.Test;

public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = count++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                matrix[i][right] = count++;
            }
            if (left != right && top != bottom) {
                for (int i = right - 1; i >= left; i--) {
                    matrix[bottom][i] = count++;
                }
                for (int i = bottom - 1; i >= top + 1; i--) {
                    matrix[i][left] = count++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }

    @Test
    public void test() {
        int[][] ints = generateMatrix(3);
    }
}
