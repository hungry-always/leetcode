package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution37 {
    public void solveSudoku(char[][] board) {
        Set<Character>[] sets = new Set[27];
        Set<Character> set = Set.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        Arrays.fill(sets, new HashSet<>(set));
        for (int i = 0; i < 9; i++) {
            for (int j = 9; j > 0; j--) {
                char c = board[i][j];
                sets[i].add(c);
                sets[j + 9].add(c);
                sets[(i / 3) * 3 + j / 3 + 18].add(c);
            }
        }
    }

    @Test
    public void test() {

    }
}
