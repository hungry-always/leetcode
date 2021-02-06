package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> list = new LinkedList<>();
        int length = intervals.length;
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            int[] interval = intervals[i];
            int start1 = interval[0];
            int end1 = interval[1];
            if (i == 0) {
                start = start1;
                end = end1;
            } else if (end >= start1) {
                start = Math.min(start, start1);
                end = Math.max(end, end1);
            } else {
                list.add(new int[]{start, end});
                start = start1;
                end = end1;
            }
            if (i == length - 1) {
                list.add(new int[]{start, end});
            }
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    @Test
    public void test() {
    }
}
