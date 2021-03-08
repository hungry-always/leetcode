package everyWeek.s15;

import commmon.ArraysUtils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution4 {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] result = new int[queries.length];
        Map<Sign, Integer> map = new HashMap<>();
        int[] count = new int[n];
        for (int[] edge : edges) {
            int i = edge[0] - 1;
            count[i]++;
            int j = edge[1] - 1;
            count[j]++;
            if (i > j) {
                int temp = j;
                j = i;
                i = temp;
            }
            Sign sign = new Sign(i, j);
            map.put(sign, map.getOrDefault(sign, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int num = count[i] + count[j] - map.getOrDefault(new Sign(i, j), 0);
                for (int k = 0; k < queries.length; k++) {
                    if (queries[k] < num) {
                        result[k]++;
                    }
                }
            }
        }
        return result;
    }

    class Sign {
        int i;
        int j;

        public Sign(int i, int j) {
            if (i > j) {
                int temp = j;
                j = i;
                i = temp;
            }
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Sign)) return false;
            Sign sign = (Sign) o;
            return i == sign.i && j == sign.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    @Test
    public void test() {
        String s = "[[2,5],[5,4],[4,3],[7,3],[5,8],[6,1],[7,5],[6,1],[7,5],[3,1],[6,4],[6,8],[6,5],[5,6],[8,1],[1,6],[1,3],[5,6],[8,3],[6,2]]";
        int[][] ints = ArraysUtils.generateTwo(s);
        String s1 = "[2,5,4,3,0,4,4,3,3,2,3,1,5,7,5,1,6,18,14]";
        int[] ints1 = ArraysUtils.generateOne(s1);
        int[] ints2 = countPairs(8, ints, ints1);
    }
}
