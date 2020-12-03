package everyWeek;

import org.junit.jupiter.api.Test;

public class Solution {
    public int maxRepeating(String sequence, String word) {
        int length = sequence.length();
        int length1 = word.length();
        if (length1 > length) {
            return 0;
        }
        int count = 0;
        int doing = 0;
        int doingCount = 0;
        boolean start = false;
        for (int i = 0; i < length; i++) {
            char c = sequence.charAt(i);
            char c1 = word.charAt(doing);
            if (c == c1) {
                if (doing == length1 - 1) {
                    doing = 0;
                    doingCount++;
                    start = false;
                } else {
                    doing++;
                    start = true;
                }
            } else {
                if (start) {
                    start = false;
                    i -= doing;
                }
                doing = 0;
                doingCount = 0;
            }
            count = Math.max(doingCount, count);
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(maxRepeating("ababc", "abc"));
    }
}
