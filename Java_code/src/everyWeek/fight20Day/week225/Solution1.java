package everyWeek.fight20Day.week225;

import org.junit.jupiter.api.Test;

public class Solution1 {
    public String maximumTime(String time) {
        StringBuilder sb = new StringBuilder(time);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '?') {
                if (i == 0) {
                    if (sb.charAt(i + 1) == '?' || sb.charAt(i + 1) <= '3') {
                        c = '2';
                    } else {
                        c = '1';
                    }
                } else if (i == 1) {
                    if (sb.charAt(i - 1) == '2') {
                        c = '3';
                    } else {
                        c = '9';
                    }
                } else if (i == 3) {
                    c = '5';
                } else if (i == 4) {
                    c = '9';
                }
            }
            sb.setCharAt(i, c);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(maximumTime("?0:15"));
        System.out.println(maximumTime("0?:3?"));
        System.out.println(maximumTime("1?:22"));
    }
}
