package everyWeek.fight20Day.weekDouble22;

import org.junit.jupiter.api.Test;

public class Solution1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int i : arr1) {
            boolean flag = true;
            for (int j : arr2) {
                if (Math.abs(i - j) <= d) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[] ints = {4, 5, 8};
        int[] ints1 = {10, 9, 1, 8};
        System.out.println(findTheDistanceValue(ints, ints1, 2));
    }
}
