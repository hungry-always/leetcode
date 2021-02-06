package everyWeek.fight20Day.week183;

import org.junit.jupiter.api.Test;

public class Solution1404 {
    public int numSteps(String s) {
        boolean moreOne = false;
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() >= 2) {
            char c = sb.charAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            count++;
            if ((c == '0' && moreOne) || (c == '1' && !moreOne)) {
                count++;
                moreOne = true;
            }
        }
        if (sb.charAt(0) == '1' && moreOne) {
            count++;
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(numSteps("1"));
    }
}
