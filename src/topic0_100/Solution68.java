package topic0_100;

import commmon.ArraysUtils;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution68 {
    private final int a = 1000_000_007;

    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> sellQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> buyQueue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            if (order[2] == 0) {
                if (sellQueue.isEmpty() || sellQueue.peek()[0] > price) {
                    buyQueue.add(order);
                } else {
                    while (amount > 0 && !sellQueue.isEmpty() && sellQueue.peek()[0] <= price) {
                        int[] poll = sellQueue.poll();
                        if (poll[1] >= amount) {

                            poll[1] -= amount;
                            amount = 0;
                            if (poll[1] > 0) {
                                sellQueue.add(poll);
                            }
                        } else {
                            amount -= poll[1];
                        }
                    }
                    if (amount > 0) {
                        order[1] = amount;
                        buyQueue.add(order);
                    }
                }
            }
            if (order[2] == 1) {
                if (buyQueue.isEmpty() || buyQueue.peek()[0] < price) {
                    sellQueue.add(order);
                } else {
                    while (amount > 0 && !buyQueue.isEmpty() && buyQueue.peek()[0] >= price) {
                        int[] poll = buyQueue.poll();
                        if (poll[1] >= amount) {

                            poll[1] -= amount;
                            amount = 0;
                            if (poll[1] > 0) {
                                sellQueue.add(poll);
                            }
                        } else {
                            amount -= poll[1];
                        }
                    }
                    if (amount > 0) {
                        order[1] = amount;
                        buyQueue.add(order);
                    }
                }
            }
        }
        int sum = 0;
        while (!sellQueue.isEmpty()) {
            sum += sellQueue.poll()[1];
            sum %= a;
        }
        while (!buyQueue.isEmpty()) {
            sum += buyQueue.poll()[1];
            sum %= a;
        }
        return sum;
    }

    @Test
    public void test() {
        int[][] ints = ArraysUtils.generateTwo("[[19,28,0],[9,4,1],[25,15,1]]");
        int numberOfBacklogOrders = getNumberOfBacklogOrders(ints);
        System.out.println(numberOfBacklogOrders);
        Integer[] ints1 = {123};
        List<Integer> list = Arrays.asList(ints1);
    }
}
