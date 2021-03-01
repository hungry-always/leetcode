package everyDay.date_2021.Feb;

import org.junit.jupiter.api.Test;

public class Solution2_22 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int num = matrix[i][0];
            int temp1 = i, temp2 = 0;
            while (temp1 < m && temp2 < n) {
                if (matrix[temp1][temp2] != num) {
                    return false;
                }
                temp1++;
                temp2++;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = matrix[0][i];
            int temp1 = i, temp2 = 0;
            while (temp2 < m && temp1 < n) {
                if (matrix[temp2][temp1] != num) {
                    return false;
                }
                temp1++;
                temp2++;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[][] nums = {{65, 98, 57}};
        System.out.println(isToeplitzMatrix(nums));
    }
}
