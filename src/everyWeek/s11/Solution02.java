package everyWeek.s11;

import org.junit.jupiter.api.Test;

public class Solution02 {
    public int maximumScore(int a, int b, int c) {
        int temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        if (a < c) {
            temp = c;
            c = b;
            b = a;
            a = temp;
        } else if (b < c) {
            temp = c;
            c = b;
            b = temp;
        }
        if (b + c < a) {
            return b + c;
        } else {
            return (a + b + c) / 2;
        }
    }

    @Test
    public void test() {
        int i = maximumScore(1, 8, 8);
        System.out.println(i);
    }
}
