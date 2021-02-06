package topic0_100;

import org.junit.jupiter.api.Test;

/**
 * 最常回文子串
 */
class Solution05 {
    public String longestPalindrome(String s) {
        String result = "";
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j + i < length; j++) {
                int k = i + j;
                if (i == 0) {
                    dp[j][k] = true;
                } else if (i == 1) {
                    dp[j][k] = (s.charAt(j) == s.charAt(k));
                } else {
                    dp[j][k] = dp[j + 1][k - 1] && (s.charAt(j) == s.charAt(k));
                }
                if (dp[j][k]&&i + 1 > result.length()) {
                    result = s.substring(j, k + 1);
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(longestPalindrome("asdfabbaasfasd"));
    }
}
