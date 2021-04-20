import commmon.ArraysUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1801 {
    public int getNumberOfBacklogOrders(int[][] orders) {
        int mod = 1_000_000_007;
        PriorityQueue<int[]> sellQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> buyQueue = new PriorityQueue<>(Comparator.comparingInt(o -> -o[0]));
        for (int[] order : orders) {
            int price = order[0];
            int orderType = order[2];
            if (orderType == 0) {
                while (!sellQueue.isEmpty() && sellQueue.peek()[0] <= price && order[1] > 0) {
                    int[] poll = sellQueue.poll();
                    int min = Math.min(poll[1], order[1]);
                    order[1] -= min;
                    poll[1] -= min;
                    if (poll[1] != 0) {
                        sellQueue.add(poll);
                    }
                }
                if (order[1] != 0) {
                    buyQueue.add(order);
                }
            } else {
                while (!buyQueue.isEmpty() && buyQueue.peek()[0] >= price && order[1] > 0) {
                    int[] poll = buyQueue.poll();
                    int min = Math.min(poll[1], order[1]);
                    order[1] -= min;
                    poll[1] -= min;
                    if (poll[1] != 0) {
                        buyQueue.add(poll);
                    }
                }
                if (order[1] != 0) {
                    sellQueue.add(order);
                }
            }
        }
        int sum = 0;
        while (!sellQueue.isEmpty()) {
            sum += sellQueue.poll()[1];
            sum %= mod;
        }
        while (!buyQueue.isEmpty()) {
            sum += buyQueue.poll()[1];
            sum %= mod;
        }
        return sum;
    }

    @Test
    public void test() {
        int[][] ints = ArraysUtils.generateTwo("[[7,1000000000,1],[15,3,0],[5,999999995,0],[5,1,1]]");
        System.out.println(Arrays.toString(ints));
        int numberOfBacklogOrders = getNumberOfBacklogOrders(ints);
        System.out.println(numberOfBacklogOrders);
    }
}
