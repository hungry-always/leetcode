package generalize.dj;

import commmon.ArraysUtils;
import org.junit.jupiter.api.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.*;

public class Solution1786 {
    public int countRestrictedPaths(int n, int[][] edges) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        List<List<int[]>> lists = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            lists.get(u).add(edge);
            lists.get(v).add(edge);
        }
        dist[n - 1] = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> dist[a]));
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<int[]> list = lists.get(poll);
            for (int[] edge : list) {
                int v = edge[1] -1;
                int weight = edge[2];
                if (dist[v] > dist[poll]) {
                    dist[v] = Math.min(dist[v], dist[poll] + weight);
                }
            }
        }
        return 1;
    }

    @Test
    public void test() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadId());
            System.out.println(threadInfo.getThreadName());
        }
    }
}
