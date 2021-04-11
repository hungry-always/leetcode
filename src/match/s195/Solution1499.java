package match.s195;

import java.util.*;

public class Solution1499 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            while (!deque.isEmpty() && point[0] - points[deque.getFirst()][0] > k) {
                deque.removeFirst();
            }
            if (!deque.isEmpty()) {
                int[] point1 = points[deque.getFirst()];
                max = Math.max(max, point[0] + point[1] + point1[0] - point1[1]);
            }
            while (!deque.isEmpty()) {
                int[] point1 = points[deque.getLast()];
                if (point1[1] - point[0] <= point[1] - point[0]) {
                    deque.removeLast();
                }
            }
            deque.add(i);
        }
        return max;
    }
}
