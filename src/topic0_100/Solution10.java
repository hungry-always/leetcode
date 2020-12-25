package topic0_100;

import org.junit.jupiter.api.Test;

/**
 * 正则表达式匹配
 */
class Solution10 {
    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        boolean[][] dp = new boolean[pl + 1][sl + 1];
        for (int i = 1; i <= pl / 2; i++) {
            if (p.charAt(2 * i - 1) == '*') {
                dp[2 * i][0] = true;
            } else {
                break;
            }
        }
        dp[0][0] = true;
        for (int i = 1; i < pl + 1; i++) {
            for (int j = 1; j < sl + 1; j++) {
                if (p.charAt(i - 1) != '*') {
                    dp[i][j] = isMatch(p.charAt(i - 1), s.charAt(j - 1)) && dp[i - 1][j - 1];
                } else {
                    if (isMatch(p.charAt(i - 2) , s.charAt(j - 1))) {
                        dp[i][j] = dp[i - 2][j] || dp[i][j - 1];
                    } else {
                        dp[i][j] = dp[i - 2][j];
                    }
                }
            }
        }
        return dp[pl][sl];
    }

    private boolean isMatch(char a, char b) {
        return a == '.' || b == '.' || a == b;
    }

    @Test
    public void test() {
        boolean match = isMatch("aa", "a");
        System.out.println(match);
    }
}
