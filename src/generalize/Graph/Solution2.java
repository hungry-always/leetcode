package generalize.Graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 课程表 II
 */
public class Solution2 {
    int[] result;
    List<List<Integer>> edges;
    int count;
    int[] enter;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        result = new int[numCourses];
        enter = new int[numCourses];
        edges = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            edges.add(new LinkedList<>());
        }
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[0]).add(prerequisite[1]);
            enter[prerequisite[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (enter[i] == 0) {
                queue.add(i);
            }
        }
        count = numCourses;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            result[--count] = poll;
            for (Integer index : edges.get(poll)) {
                enter[index]--;
                if (enter[index] == 0) {
                    queue.add(index);
                }
            }
        }
        return (count == 0) ? result : new int[]{};
    }

    @Test
    public void test() {
        int[] order = findOrder(2, new int[][]{{1, 0}});
        System.out.println(order);
    }
}
