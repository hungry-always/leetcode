package everyWeek.s232;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            int i1 = edge[0];
            int i2 = edge[1];
            map.put(i1, map.getOrDefault(i1, 0) + 1);
            map.put(i2, map.getOrDefault(i2, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == map.size() - 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
