package everyWeek.s1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution04 {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        List<int[]> curRes = new LinkedList<>();
        curRes.add(new int[]{2, maxBoxes - 1, maxWeight - boxes[0][1]});
        for (int i = 1; i < boxes.length; ++i) {
            List<int[]> nextRes = new LinkedList<>();
            for (int[] pre : curRes) {
                if (pre[1] > 0 && pre[2] >= boxes[i][1]) {
                    nextRes.add(new int[]{pre[0] + (boxes[i][0] == boxes[i - 1][0] ? 0 : 1), pre[1] - 1, pre[2] - boxes[i][1]});
                }
                nextRes.add(new int[]{pre[0] + 2, maxBoxes - 1, maxWeight - boxes[i][1]});
            }
            Collections.sort(nextRes, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return b[1] - a[1];
            });
            curRes.clear();
            int min = nextRes.get(0)[0];
            curRes.add(nextRes.get(0));
            nextRes.remove(0);
            for (int[] a : nextRes) {
                if (a[0] - 1 == min) {
                    curRes.add(a);
                    break;
                } else {
                    continue;
                }
            }
        }

        return curRes.get(0)[0];
    }
}
