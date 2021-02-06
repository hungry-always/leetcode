package topic101_200;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution200 {
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int count = 0;
        int length1 = grid.length;
        for (int i = 0; i < length1; i++) {
            int length2 = grid[0].length;
            for (int j = 0; j < length2; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int i1 = poll[0];
                        int j1 = poll[1];
                        grid[i1][j1] = '0';
                        addOtherToQueue(grid, queue, i1 + 1, j1, length1 - 1, length2 - 1);
                        addOtherToQueue(grid, queue, i1, j1 + 1, length1 - 1, length2 - 1);
                        addOtherToQueue(grid, queue, i1, j1 -1, length1 - 1, length2 - 1);
                        addOtherToQueue(grid, queue, i1-1, j1, length1 - 1, length2 - 1);
                    }
                }
            }
        }
        return count;
    }

    private void addOtherToQueue(char[][] grid, Queue<int[]> queue, int i1, int j1, int i, int j) {
        if (i1 >= 0 && i1 <= i && j1 >= 0 && j1 <= j && grid[i1][j1] == '1') {
            grid[i1][j1] = '0';
            queue.add(new int[]{i1, j1});
        }
    }

    @Test
    public void test() {
//        char[][] chars = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] chars = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        int i = numIslands(chars);
        System.out.println(i);
    }
}
