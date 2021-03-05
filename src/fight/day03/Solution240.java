package fight.day03;

/**
 * 从左下角开始往右上找
 */
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            int num = matrix[i][j];
            if (num == target) {
                return true;
            } else if (num > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
