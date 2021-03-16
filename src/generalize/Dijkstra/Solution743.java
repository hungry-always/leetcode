package generalize.Dijkstra;

import commmon.ArraysUtils;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> lists = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }
        for (int[] time : times) {
            lists.get(time[0]).add(time);
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = dist[0] = 0;
        for (int[] nums : lists.get(k)) {
            dist[nums[1]] = nums[2];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> dist[o]));
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<int[]> list = lists.get(poll);
            for (int[] ints : list) {
                int index = ints[1];
                if (dist[poll] < dist[index]) {
                    dist[index] = Math.min(dist[index], dist[poll] + ints[2]);
                    queue.remove(index);
                    queue.add(index);
                }
            }
        }
        int max = 0;
        for (int i : dist) {
            max = Math.max(i, max);
        }
        return (max == Integer.MAX_VALUE) ? -1 : max;
    }

    @Test
    public void test() {
        int[][] ints = ArraysUtils.generateTwo("[[1,2,1],[2,1,3]]");
        int i = networkDelayTime(ints, 2, 2);
        System.out.println(i);
    }
}
