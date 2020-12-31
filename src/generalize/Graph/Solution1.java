package generalize.Graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 207. 课程表
 */
public class Solution1 {
    int[] status;
    List<List<Integer>> edges;

    /**
     * 深度优先搜索
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new LinkedList<>());
        }
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        status = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            try {
                dfs(i);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int i) {
        if (status[i] == 2) {
            return;
        }
        if (status[i] == 1) {
            throw new RuntimeException("存在环");
        }
        status[i] = 1;
        List<Integer> list = edges.get(i);
        for (Integer index : list) {
            dfs(index);
        }
        status[i] = 2;
    }

    @Test
    public void test() {
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
