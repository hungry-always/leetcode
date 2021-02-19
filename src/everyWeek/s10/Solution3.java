package everyWeek.s10;

import org.junit.jupiter.api.Test;

public class Solution3 {
    public int minimumLength(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (true) {
            if (start == end || s.charAt(start) != s.charAt(end)) {
                return end - start + 1;
            }
            int startEnd = getEnd(s, start);
            int endStart = getStart(s, end);
            if (startEnd >= endStart) {
                return 0;
            } else {
                start = startEnd+1;
                end = endStart-1;
            }
        }
    }

    private int getStart(String s, int end) {
        char c = s.charAt(end);
        for (int i = end; i >= 0; i--) {
            if (c != s.charAt(i)) {
                return i + 1;
            }
        }
        return 0;
    }

    private int getEnd(String s, int start) {
        char c = s.charAt(start);
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                return i - 1;
            }
        }
        return s.length() - 1;
    }

    @Test
    public void test() {
        System.out.println(minimumLength("aabccabba"));
    }
}
