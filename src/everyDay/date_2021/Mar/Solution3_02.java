package everyDay.date_2021.Mar;

/**
 * 二维区域和检索-矩阵不可变
 */
public class Solution3_02 {
}
class NumMatrix {
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(dp == null){
            return 0;
        }
        return dp[row2+1][col2+1] + dp[row1][col1] - dp[row2+1][col1] - dp[row1][col2+1];
    }
}
