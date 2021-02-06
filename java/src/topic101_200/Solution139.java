package topic101_200;

import java.util.*;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        for (int i = 1; i < length + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[i] && set.contains(s.substring(j, i))) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[length + 1];
    }
}
