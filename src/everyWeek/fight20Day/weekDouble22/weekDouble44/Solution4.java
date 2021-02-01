package everyWeek.fight20Day.weekDouble22.weekDouble44;

import org.junit.jupiter.api.Test;

public class Solution4 {

    public int largestAltitude(int[] gain) {
        int max = 0;
        int first = 0;
        for (int i : gain) {
            first += i;
            max = Math.max(max, first);
        }
        return max;
    }
    @Test
    public void test() {
        System.out.println(largestAltitude(new int[]{-5, 1, 5, 0, -7}));
    }
}
