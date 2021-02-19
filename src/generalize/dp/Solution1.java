package generalize.dp;

import org.junit.jupiter.api.Test;

/**
 * 通配符匹配
 */
public class Solution1 {
    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        boolean[][] dp = new boolean[pl + 1][sl + 1];
        dp[0][0] = true;
        if (pl >= 1) {
            int count = 0;
            for (int i = 0; i < pl; i++) {
                if (p.charAt(i) == '*') {
                    count++;
                } else {
                    break;
                }
            }
            for (int i = 1; i <= count; i++) {
                for (int k = 0; k <= sl; k++) {
                    dp[i][k] = true;
                }
            }
        }
        for (int i = 1; i <= pl; i++) {
            char c = p.charAt(i - 1);
            if (c != '*') {
                for (int j = 1; j <= sl; j++) {
                    dp[i][j] = isMatch(c, s.charAt(j - 1)) && dp[i - 1][j - 1];
                }
            } else {
                for (int j = 1; j <= sl; j++) {
                    if (dp[i - 1][j]) {
                        while (j <= sl) {
                            dp[i][j] = true;
                            j++;
                        }
                    }
                }
            }
        }
        return dp[pl][sl];
    }

    private boolean isMatch(char c1, char c2) {
        if (c1 == '?' || c2 == '?') {
            return true;
        } else {
            return c1 == c2;
        }
    }

    @Test
    public void test() {
//        System.out.println(isMatch("aa", "a"));// false
//        System.out.println(isMatch("aa", "*"));// true
//        System.out.println(isMatch("adceb", "*a*b"));// true
        System.out.println(isMatch("abcabczzzde", "*abc???de"));// true
//        System.out.println(isMatch("sissippi", "*ss*?i*pi"));// false

    }
}
