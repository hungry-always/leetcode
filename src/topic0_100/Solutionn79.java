package topic0_100;

public class Solutionn79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] dp = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (check(board, dp, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, boolean[][] dp, String word, int start, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || dp[i][j]) {
            return false;
        }
        if(start==word.length()-1&&board[i][j]==word.charAt(start)){
            return true;
        }
        if (board[i][j] == word.charAt(start)) {
            start++;
        }else {
            return false;
        }
        dp[i][j] = true;
        if (check(board, dp, word, start, i + 1, j) ||
                check(board, dp, word, start, i - 1, j) ||
                check(board, dp, word, start, i, j + 1) ||
                check(board, dp, word, start, i, j - 1)
        ) {
            return true;
        }
        dp[i][j] = false;
        return false;
    }
}
