package topic301_400;

import java.util.Arrays;
import java.util.Comparator;

public class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });
        int n = envelopes.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        }
        dp[0] = envelopes[0];
        for (int i = 1; i < n; i++) {
            int start = 0, end = n - 1;
            int number = envelopes[i][1];
            while (start <= end) {
                int mid = (start + end) / 2;
                int midNum = dp[mid][1];
                if (midNum > number) {
                    int min = (mid - 1) == -1 ? Integer.MIN_VALUE : dp[mid - 1][1];
                    int min2 = (mid - 1) == -1 ? Integer.MIN_VALUE : dp[mid - 1][0];
                    if (min < number && min2 < envelopes[i][0]) {
                        dp[mid] = envelopes[i];
                        break;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    start = mid + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (i + 1 >= n || dp[i + 1][1] == Integer.MAX_VALUE) {
                return i + 1;
            }
        }
        return 0;
    }
}
