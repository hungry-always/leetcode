package topic0_100;

import commmon.ArraysUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean flag = false;
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (!flag) {
                if (coincide(newInterval, interval)) {
                    interval[0] = Math.min(interval[0], newInterval[0]);
                    interval[1] = Math.max(interval[1], newInterval[1]);
                    flag = true;
                } else if (newInterval[1] < interval[0]) {
                    stack.push(newInterval);
                    flag = true;
                }
            }
            while (!stack.isEmpty() && coincide(stack.peek(), interval)) {
                int[] pop = stack.pop();
                interval[0] = Math.min(interval[0], pop[0]);
                interval[1] = Math.max(interval[1], pop[1]);
            }
            stack.push(interval);
        }
        if (!flag) {
            stack.push(newInterval);
        }
        int[][] ints = new int[stack.size()][2];
        for (int length = ints.length - 1; length >= 0; length--) {
            ints[length] = stack.pop();
        }
        return ints;
    }

    private boolean coincide(int[] arr1, int[] arr2) {
        return (arr1[0] <= arr2[0] && arr2[0] <= arr1[1])
                || (arr1[0] <= arr2[1] && arr2[1] <= arr1[1])
                || (arr2[0] <= arr1[0] && arr2[1] >= arr1[1]);
    }

    @Test
    public void test() {
        int[][] ints = ArraysUtils.generateTwo("[[1,5]]");
        int[][] insert = insert(ints, new int[]{6, 8});
        System.out.println(insert);
    }
}
