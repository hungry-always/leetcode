package everyWeek.fight20Day.week182;

import org.junit.jupiter.api.Test;

public class Solution1395 {
    public int numTeams(int[] rating) {
        int result = 0;
        for (int i = 1; i < rating.length - 1; i++) {
            int num = rating[i];
            int small1 = 0, small2 = 0, big1 = 0, big2 = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] > num) {
                    big1++;
                } else if (rating[j] < num) {
                    small1++;
                }
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] > num) {
                    big2++;
                } else if (rating[j] < num) {
                    small2++;
                }
            }
            result += big1 * small2 + big2 * small1;
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(numTeams(new int[]{2, 5, 3, 4, 1}));
    }
}
