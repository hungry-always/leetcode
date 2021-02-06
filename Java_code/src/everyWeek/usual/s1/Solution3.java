package everyWeek.usual.s1;

import java.util.Arrays;

public class Solution3 {
    public static int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int length = bobValues.length;
        int[][] dp = new int[length][2];
        for (int i = 0; i < length; i++) {
            dp[i] = new int[]{aliceValues[i] + bobValues[i], i};
        }
        Arrays.sort(dp, (o1, o2) -> o2[0] - o1[0]);
        int aCount = 0;
        int bCount = 0;
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                aCount += aliceValues[dp[i][1]];
            } else {
                bCount += bobValues[dp[i][1]];
            }
        }
        if (aCount > bCount) {
            return 1;
        } else if (aCount == bCount) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,3};
        int[] b = {2,1};
        System.out.println(stoneGameVI(a, b));
    }
}
