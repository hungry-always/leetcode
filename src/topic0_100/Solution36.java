package topic0_100;

import java.util.HashSet;
import java.util.Set;

public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[][] sets = new Set[3][3];
        Set<Character>[] sets1 = new Set[9];
        Set<Character>[] sets2 = new Set[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sets[i][j] = new HashSet<>();
            }
        }
        for (int i = 0; i < 9; i++) {
            sets1[i] = new HashSet<>();
            sets2[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int k1 = i / 3;
                int k2 = j / 3;
                if (sets1[i].contains(c) || sets2[j].contains(c) || sets[k1][k2].contains(c)) {
                    return false;
                }
                sets1[i].add(c);
                sets2[j].add(c);
                sets[k1][k2].add(c);
            }
        }
        return true;
    }
}
