package everyWeek.s2;

import org.junit.jupiter.api.Test;

public class Solution4 {
    public int maxHeight(int[][] cuboids) {
        int l = Integer.MAX_VALUE;
        int w = Integer.MAX_VALUE;
        return maxHeight(cuboids, 0, l, w);
    }

    private int maxHeight(int[][] cuboids, int start, int l, int w) {
        if (start > cuboids.length - 1) {
            return 0;
        } else {
            int[] cuboid = cuboids[start];
            int count1 = 0;
            if (l >= cuboid[1] && w >= cuboid[0]) {
                int i = cuboid[2] + maxHeight(cuboids, start + 1, Math.min(cuboid[1], l), Math.min(cuboid[0], w));
                count1 = Math.max(i, count1);
            }
            if (l >= cuboid[0] && w >= cuboid[1]) {
                int i = cuboid[2] + maxHeight(cuboids, start + 1, Math.min(cuboid[0], l), Math.min(cuboid[1], w));
                count1 = Math.max(i, count1);
            }
            if (l >= cuboid[1] && w >= cuboid[2]) {
                int i = cuboid[0] + maxHeight(cuboids, start + 1, Math.min(cuboid[1], l), Math.min(cuboid[2], w));
                count1 = Math.max(i, count1);
            }
            if (l >= cuboid[2] && w >= cuboid[1]) {
                int i = cuboid[0] + maxHeight(cuboids, start + 1, Math.min(cuboid[2], l), Math.min(cuboid[1], w));
                count1 = Math.max(i, count1);
            }
            if (l >= cuboid[2] && w >= cuboid[0]) {
                int i = cuboid[1] + maxHeight(cuboids, start + 1, Math.min(cuboid[2], l), Math.min(cuboid[0], w));
                count1 = Math.max(i, count1);
            }
            if (l >= cuboid[0] && w >= cuboid[2]) {
                int i = cuboid[1] + maxHeight(cuboids, start + 1, Math.min(cuboid[0], l), Math.min(cuboid[2], w));
                count1 = Math.max(i, count1);
            }
            int count = maxHeight(cuboids, start + 1, l, w);
            return Math.max(count1, count);
        }
    }

    @Test
    public void test() {
        int[][] nums = {{50, 45, 20}, {95, 37, 53}, {45, 23, 12}};
        System.out.println(maxHeight(nums));
    }
}
