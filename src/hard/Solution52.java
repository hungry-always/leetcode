package hard;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution52 {
    int count = 0;
    public int totalNQueens(int n) {
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> slashSet1 = new HashSet<>();
        Set<Integer> slashSet2 = new HashSet<>();
        totalNQueens(0, n, colSet, slashSet1, slashSet2);
        return count;
    }

    private void totalNQueens(int i, int n, Set<Integer> colSet, Set<Integer> slashSet1, Set<Integer> slashSet2) {
        if (i == n) {
            count++;
        } else {
            for (int j = 0; j < n; j++) {
                if (!colSet.contains(j) && !slashSet1.contains(i + j) && !slashSet2.contains(i - j)) {
                    colSet.add(j);
                    slashSet1.add(i + j);
                    slashSet2.add(i - j);
                    totalNQueens(i + 1, n, colSet, slashSet1, slashSet2);
                    colSet.remove(j);
                    slashSet1.remove(i + j);
                    slashSet2.remove(i - j);
                }
            }
        }
    }

    @Test
    public void test() {
        System.out.println(totalNQueens(4));
    }
}
