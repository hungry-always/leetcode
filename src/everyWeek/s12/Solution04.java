package everyWeek.s12;

public class Solution04 {
    public int longestPalindrome(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int length = n + m;
        int count = 0;
        int[][] dp = new int[length][length];
        for (int i = length; i > 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < length; j++) {
                if (getChar(word1, word2, i) == getChar(word1, word2, j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                    if (i < n && j >= n) {
                        count = Math.max(count, dp[i][j]);
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return count;
    }

    private char getChar(String word1, String word2, int index) {
        if (index < word1.length()) {
            return word1.charAt(index);
        } else if (index < word1.length() + word2.length()) {
            return word2.charAt(index - word1.length());
        } else {
            return ' ';
        }
    }
}
