package generalize.deepSearch;

import commmon.ArraysUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution542 {
    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] arr = new int[n][m];
        for (int[] ints : arr) {
            Arrays.fill(ints, -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int i1 = poll[0];
                int i2 = poll[1];
                if (arr[i1][i2] == -1) {
                    arr[i1][i2] = count;
                    addToQueue(queue, i1 - 1, i2, arr);
                    addToQueue(queue, i1 + 1, i2, arr);
                    addToQueue(queue, i1, i2 - 1, arr);
                    addToQueue(queue, i1, i2 + 1, arr);
                }
            }
            count++;
        }
        return arr;
    }

    private void addToQueue(Queue<int[]> queue, int i, int j, int[][] arr) {
        if (i < arr.length && i >= 0 && j < arr[0].length && j >= 0 && arr[i][j] == -1) {
            queue.add(new int[]{i, j});
        }
    }

    @Test
    public void test() {
        int[][] ints = ArraysUtils.generateTwo("[[0,0,0],\n" +
                " [0,1,0],\n" +
                " [1,1,1]]");
        int[][] ints1 = updateMatrix(ints);
        System.out.println(ints1);
    }

}
