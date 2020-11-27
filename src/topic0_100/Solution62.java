package topic0_100;

import org.junit.jupiter.api.Test;

/**
 * 不同路径
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        return chooseMFromN(m - 1, m + n - 2);
    }

    int chooseMFromN(int m, int n) {
        if (n < m) {
            return 0;
        }
        m = Math.min(n - m, m);
        long result = 1L;
        int count = 0;
        while (count != m) {
            result = result * n-- / ++count;
        }
        return (int)result;
    }

    @Test
    public void test() {
        System.out.println(uniquePaths(51, 9));
    }
}
