package topic0_100;

import org.junit.jupiter.api.Test;

public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            int height = matrix[0].length;
            int[] subMatrix = matrix[i];
            if (subMatrix[0] <= target && subMatrix[height - 1] >= target) {
                int point1 = 0;
                int point2 = height - 1;
                while (point1 <= point2) {
                    int start = subMatrix[point1];
                    int end = subMatrix[point2];
                    if (start == target || end == target) {
                        return true;
                    } else {
                        point1++;
                        point2--;
                    }
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[][] ints = {{}};
        System.out.println(searchMatrix(ints, 1));
    }
}
