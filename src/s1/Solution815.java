package s1;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            for (int key : route) {
                Set<Integer> set = map.getOrDefault(key, new HashSet<>());
                set.add(i);
                map.put(key, set);
            }
        }
        Set<Integer> dp = new HashSet<>();
        boolean[] routeDp = new boolean[routes.length];
        dp.add(source);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                Set<Integer> pollSet = map.get(poll);
                for (Integer key : pollSet) {
                    if (!routeDp[key]) {
                        routeDp[key] = true;
                        int[] route = routes[key];
                        if (Arrays.stream(route).filter(a -> a == target).findAny().isPresent()) {
                            return count;
                        }
                        for (int subKey : route) {
                            if (!dp.contains(subKey)) {
                                dp.add(subKey);
                                queue.add(subKey);
                            }
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }

    @Test
    public void test() {
        int[][] nums = {{1, 2, 7}, {3, 6, 7}};
        int i = numBusesToDestination(nums, 1, 6);
        System.out.println(i);
    }
}
