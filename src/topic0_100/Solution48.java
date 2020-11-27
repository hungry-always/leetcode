package topic0_100;

import org.junit.jupiter.api.Test;

public class Solution48 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        if (length == 0) {
            return;
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length-i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - j][length - 1 - i];
                matrix[length - 1 - j][length - 1 - i] = temp;
            }
        }
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - i][j];
                matrix[length - 1 - i][j] = temp;
            }
        }
        System.out.println(1);
    }

    @Test
    public void test() {
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(ints);
    }
}
