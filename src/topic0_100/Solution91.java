package topic0_100;

import org.junit.jupiter.api.Test;

public class Solution91 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                return 0;
            } else if (i + 1 < n && s.charAt(i) == '0') {
                if (s.charAt(i) > '2') {
                    return 0;
                } else {
                    dp[i + 2] += dp[i];
                }
            } else {
                dp[i + 1] += dp[i];
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println('0' - 0);
    }
}
