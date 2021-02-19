package everyWeek.s10;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution4 {
    Map<String, Integer> map = new HashMap<>();
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
        return move(events, 0, 1, 0, k);
    }

    private int move(int[][] events, int startIndex, int startTime, int count, int k) {
        int result;
        String key = startIndex + "#" + startTime + "#" + count;
        if (map.get(key) != null) {
            return map.get(key);
        }
        if (count >= k || startIndex >= events.length) {
            result = 0;
        } else {
            int[] event = events[startIndex];
            if (event[0] < startTime) {
                result =  move(events, startIndex + 1, startTime, count, k);
            } else {
                int i = event[2] + move(events, startIndex + 1, event[1] + 1, count + 1, k);
                int move = move(events, startIndex + 1, startTime, count, k);
                result = Math.max(i, move);
            }
        }
        return result;
    }

    @Test
    public void test() {
        int i = maxValue(new int[][]{new int[]{1, 2, 4}, new int[]{3, 4, 3}, new int[]{2, 3, 1}}, 2);
        System.out.println(i);
    }
}
