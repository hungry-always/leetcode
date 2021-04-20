package lcp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class Solution03 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        HashSet<String> set = new HashSet<>();
        int x1 = 0, y1 = 0;
        set.add(x1 + "#" + y1);
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'R') {
                x1++;
            } else {
                y1++;
            }
            set.add(x1 + "#" + y1);
        }
        if (x1 == 0) {
            if (x != 0 || Arrays.stream(obstacles).anyMatch(o -> o[0] == 0&&o[0]<=x)) {
                return false;
            } else {
                return true;
            }
        } else if (y1 == 0) {
            if (y != 0 || Arrays.stream(obstacles).anyMatch(o -> o[1] == 0 && o[1] <= y)) {
                return false;
            } else {
                return true;
            }
        } else {
            int min1 = Math.min(x / x1, y / y1);
            int i1 = x - x1 * min1;
            int j1 = y - y1 * min1;
            if (!set.contains(i1 + "#" + j1)) {
                return false;
            } else {
                for (int[] obstacle : obstacles) {
                    int o0 = obstacle[0];
                    int o1 = obstacle[1];
                    if (o0 <= x && o1 <= y) {
                        int min = Math.min(o0 / x1, o1 / y1);
                        int i = o0 - min * x1;
                        int j = o1 - min * y1;
                        if (set.contains(i + "#" + j)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    @Test
    public void test() {
        boolean urr = robot("URR", new int[][]{{2, 2}}, 3, 2);
        System.out.println(urr);
    }
}
