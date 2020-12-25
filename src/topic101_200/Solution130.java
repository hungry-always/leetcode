package topic101_200;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution130 {
    public void solve(char[][] board) {
        int length1 = board.length;
        int length2 = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < length1; i++) {
            addArrToQueue(i, length2 - 1, length1, length2, queue, board);
            addArrToQueue(i, 0, length1, length2, queue, board);
        }
        for (int i = 1; i < length2; i++) {
            addArrToQueue(length1-1, i, length1, length2, queue, board);
            addArrToQueue(0, i, length1, length2, queue, board);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int k1 = poll[0];
                int k2 = poll[1];
                board[k1][k2] = '.';
                addArrToQueue(k1 - 1, k2, length1, length2, queue, board);
                addArrToQueue(k1 + 1, k2, length1, length2, queue, board);
                addArrToQueue(k1, k2 - 1, length1, length2, queue, board);
                addArrToQueue(k1, k2 + 1, length1, length2, queue, board);
            }
        }
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
        System.out.println(1);
    }

    private void addArrToQueue(int k1, int k2, int length1, int length2, Queue<int[]> queue, char[][] board) {
        if (k1 >= 0 && k1 <= length1-1 && k2 >= 0 && k2 <= length2-1 && board[k1][k2] == 'O') {
            queue.add(new int[]{k1, k2});
        }
    }


    @Test
    public void test() {
        char[][] chars = {{'O', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(chars);
    }
}
