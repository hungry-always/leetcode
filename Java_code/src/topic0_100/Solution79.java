package topic0_100;

import org.junit.jupiter.api.Test;

public class Solution79 {
    StringBuilder sb;
    boolean[][] dp;

    public boolean exist(char[][] board, String word) {
        sb = new StringBuilder(word);
        dp = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int start, int i, int j) {
        if (start >= sb.length()) {
            return true;
        }
        if (i >= 0 && i <= dp.length && j >= 0 && j <= dp[0].length && !dp[i][j] && board[i][j] == sb.charAt(start)) {
            dp[i][j] = true;
            return exist(board, start + 1, i - 1, j) || exist(board, start + 1, i + 1, j) || exist(board, start + 1, i, j - 1) || exist(board, start + 1, i, j + 1);
        }
        return false;
    }

    @Test
    public void test() {
        char[][] chars = {{'A', 'B', 'C', 'E' }, {'S', 'F', 'C', 'S' }, {'A', 'D', 'E', 'E' }};
        boolean abcb = exist(chars, "ABCB");
        System.out.println(abcb);
    }
}
