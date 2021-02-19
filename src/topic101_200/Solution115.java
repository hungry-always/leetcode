package topic101_200;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution115 {
    public int numDistinct(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int[][] dp = new int[tLength + 1][sLength + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= tLength; i++) {
            for (int j = i; j <= sLength; j++) {
                dp[i][j] += dp[i][j - 1];
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[tLength][sLength];
    }

    @Test
    public void test() {
        String s = "qwerqwerqwerqwer";
        String t = "qw";
        int i = numDistinct(s, t);
        System.out.println(i);
    }
}
