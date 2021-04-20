package lcp;

import java.util.*;

public class Solution07 {
    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] arr : relation) {
            int num0 = arr[0];
            int num1 = arr[1];
            Set<Integer> set = map.getOrDefault(num0, new HashSet<>());
            set.add(num1);
            map.put(num0, set);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty() && k >= 2) {
            k--;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (map.get(poll) != null) {
                    queue.addAll(map.get(poll));
                }
            }
        }
        if (k != 1) {
            return 0;
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (map.get(poll) != null && map.get(poll).contains(n - 1)) {
                count++;
            }
        }
        return count;
    }
}
