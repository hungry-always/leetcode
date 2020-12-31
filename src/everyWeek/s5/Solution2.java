package everyWeek.s5;

import org.junit.jupiter.api.Test;

public class Solution2 {
    public double averageWaitingTime(int[][] customers) {
        double start = 1;
        double count = 0;
        for (int[] customer : customers) {
            int arr = customer[0];
            int time = customer[1];
            start = Math.max(start, arr);
            start += time;
            count += (start - arr);
        }
        return count / 1.000000 / customers.length;
    }

    @Test
    public void test() {
        int[][] a = {{1, 2}, {2, 5}, {4, 3}};
        System.out.println(averageWaitingTime(a));
    }
}
