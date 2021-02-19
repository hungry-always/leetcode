package topic0_100;

import java.util.Random;

public class Solution73 {
    public void setZeroes(int[][] matrix) {
        Random random = new Random();
        int i1 = random.nextInt(12334);
        int i2 = i1 + 12343432;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < m; k++) {
                        if (matrix[k][j] != 0) {
                            matrix[k][j] = i2;
                        }
                    }
                    for (int k = 0; k < n; k++) {
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = i2;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == i2) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
