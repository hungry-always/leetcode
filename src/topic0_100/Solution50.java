package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution50 {
    Map<String, Double> map = new HashMap<>();
    public double myPow(double x, int n) {
        Double result = map.get(x + "#" + n);
        if (result != null) {
            return result;
        }
        if (n == 0) {
            result = 1D;
        } else if (n == 1) {
            result = x;
        } else if (n == -1) {
            result = 1 / x;
        } else {
            int i = n % 2;
            int i1 = n / 2;
            result = myPow(x, i1) * myPow(x, i1) * myPow(x, i);
        }
        map.put(x + "#" + n, result);
        return result;
    }

    @Test
    public void test() {
//        System.out.println(myPow(2.00000, -2147483648));
//        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(8.84372,-5));
    }
}
