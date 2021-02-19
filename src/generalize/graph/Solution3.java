package generalize.graph;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution3 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] countArr = new int[n];
        for (int i = 0; i < n; i++) {
            map.put(i, new LinkedList<>());
        }
        for (int[] edge : edges) {
            countArr[edge[0]]++;
            countArr[edge[1]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] == 1) {
                queue.add(i);
            }
        }
        List<Integer> result = null;
        while (!queue.isEmpty()) {
            result = new LinkedList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                result.add(poll);
                for (Integer sub : map.get(poll)) {
                    countArr[sub]--;
                    if (countArr[sub] == 1) {
                        queue.add(sub);
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        List<Integer> minHeightTrees = findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}});
        System.out.println(minHeightTrees);
    }
}