package everyWeek.s7;

import org.junit.jupiter.api.Test;

public class Solution2 {
    public int maximumGain(String s, int x, int y) {
        int result = 0;
        String s1, s2;
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        if (x > y) {
            s1 = "ab";
            s2 = "ba";
        } else {
            s2 = "ab";
            s1 = "ba";
        }
        StringBuilder sb = new StringBuilder(s);
        while (true) {
            boolean flag = false;
            for (int i = sb.length() - 1; i >= 1; i--) {
                char c = sb.charAt(i);
                char c1 = sb.charAt(i - 1);
                if (c == s1.charAt(1) && c1 == s1.charAt(0)) {
                    result += max;
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i - 1);
                    i--;
                    if (i + 2 < sb.length() - 1) {
                        i += 2;
                    } else if (i + 1 < sb.length() - 1) {
                        i++;
                    }
                    flag = true;
                }
            }
            for (int i = sb.length() - 1; i > 0; i--) {
                if (sb.charAt(i) == s2.charAt(1) && sb.charAt(i - 1) == s2.charAt(0)) {
                    result += min;
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i - 1);
                    i--;
                    if (i + 2 < sb.length() - 1) {
                        i += 2;
                    } else if (i + 1 < sb.length() - 1) {
                        i++;
                    }
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return result;
    }
    @Test
    public void test() {
        System.out.println(maximumGain("aabbaaxybbaabb", 5, 4));
    }
}
