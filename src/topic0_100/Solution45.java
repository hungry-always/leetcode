package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution45 {
    public int getNumberOfBacklogOrders(int[][] orders) {
        Queue<int[]> buy = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        Queue<int[]> sell = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i][2] == 0) {
                if (!buy.isEmpty() && buy.peek()[0] >= orders[i][0]) {
                    buy.offer(new int[]{orders[i][0], orders[i][1]});
                } else {
                    int num = orders[i][1];
                    while (num > 0 && !sell.isEmpty() && sell.peek()[0] <= orders[i][0]) {
                        if (sell.peek()[1] >= num) {
                            sell.peek()[1] -= num;
                            num = 0;
                        } else {
                            num -= sell.poll()[1];
                        }
                    }
                    if (num > 0) {
                        buy.offer(new int[]{orders[i][0], num});
                    }
                }
            } else {
                if (!sell.isEmpty() && sell.peek()[0] <= orders[i][0]) {
                    sell.offer(new int[]{orders[i][0], orders[i][1]});
                } else {
                    int num = orders[i][1];
                    while (num > 0 && !buy.isEmpty() && buy.peek()[0] >= orders[i][0]) {
                        if (buy.peek()[1] >= num) {
                            buy.peek()[1] -= num;
                            num = 0;
                        } else {
                            num -= buy.poll()[1];
                        }
                    }
                    if (num > 0) {
                        sell.offer(new int[]{orders[i][0], num});
                    }
                }
            }
        }
        int ans = 0;
        while (!buy.isEmpty()) {
            ans += buy.poll()[1];
            ans /= 1000000007;
        }
        while (!sell.isEmpty()) {
            ans += sell.poll()[1];
            ans /= 1000000007;
        }
        return ans;
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(hammingWeight(-3));
    }
}
