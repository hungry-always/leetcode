package everyWeek.s4;

import org.junit.jupiter.api.Test;

public class Solution3 {
    public int concatenatedBinary(int n) {
        long nl = n;
        final int a = 1_000_000_007;
        long want = 1;
        long result = 0;
        while (nl >= want) {
            long count = getCount(want);
            result = (result << count) + want;
            result %= a;
            want++;
        }
        return (int) result;
    }

    private long getCount(long n) {
        int count = 1;
        while (n >= 2) {
            n >>= 1;
            count++;
        }
        return count;
    }

    @Test
    public void test() {
        int i = concatenatedBinary(12);
        System.out.println(i);
    }
}
