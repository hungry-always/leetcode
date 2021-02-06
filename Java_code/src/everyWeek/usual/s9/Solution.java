package everyWeek.usual.s9;

public class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int max = 0;
        for (int[] rectangle : rectangles) {
            max = Math.max(Math.min(rectangle[0], rectangle[1]), max);
        }
        if (max <= 0) {
            return 0;
        }
        int count = 0;
        for (int[] rectangle : rectangles) {
            if (Math.min(rectangle[0], rectangle[1]) == max) {
                count++;
            }
        }
        return count;
    }
}
