package everyWeek.s12;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution03 {
    public int[][] highestPeak(int[][] isWater) {
        int length = isWater.length;
        int length1 = isWater[0].length;
        int[][] dp = new int[length][length1];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length1; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int i1 = poll[0];
                int i2 = poll[1];
                add(queue, i1, i2 - 1, dp, isWater,dp[i1][i2]);
                add(queue, i1, i2 + 1, dp, isWater,dp[i1][i2]);
                add(queue, i1 - 1, i2, dp, isWater,dp[i1][i2]);
                add(queue, i1 + 1, i2, dp, isWater,dp[i1][i2]);
            }
        }
        return dp;
    }

    private void add(Queue<int[]> queue, int i1, int i2, int[][] dp, int[][] isWater, int value) {
        if (i1 >= 0 && i1 < isWater.length && i2 >= 0 && i2 < isWater[0].length && isWater[i1][i2] == 0) {
            if (dp[i1][i2] == 0) {
                dp[i1][i2] = value + 1;
                queue.add(new int[]{i1, i2});
            } else {
                dp[i1][i2] = Math.min(dp[i1][i2], value + 1);
            }
        }
    }

    @Test
    public void test() {
        int[][] ints = highestPeak(new int[][]{{0, 1}, {0, 0}});
        System.out.println(ints);
    }
}
