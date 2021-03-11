package everyWeek.s15;

public class Solution1 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int j = 0; j < points.length; j++) {
            int[] point = points[j];
            if (point[0] == x || point[1] == y) {
                int i = Math.abs(x - point[0]) + Math.abs(y - point[1]);
                if (i < min) {
                    index = j;
                    min = i;
                }
            }
        }
        return index;
    }
}
