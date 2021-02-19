package topic101_200;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Solution166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long numerator1 = numerator;
        long denominator1 = denominator;
        StringBuilder sb = new StringBuilder();
        if ((denominator1 > 0 && numerator1 < 0) || (denominator1 < 0 && numerator1 > 0)) {
            sb.append("-");
        }
        numerator1 = Math.abs(numerator1);
        denominator1 = Math.abs(denominator1);
        sb.append(numerator1 / denominator1);
        long remainder = numerator1 % denominator1;
        if (remainder != 0) {
            sb.append(".");
            HashMap<Long, Integer> map = new HashMap<>();
            while (remainder != 0) {
                Integer index = map.get(remainder);
                if (index != null) {
                    sb.insert(index + 1, "(");
                    sb.append(")");
                    break;
                } else {
                    map.put(remainder, sb.length() - 1);
                }
                remainder *= 10;
                sb.append(remainder / denominator1);
                remainder %= denominator1;
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(fractionToDecimal(7, -12));
        System.out.println(fractionToDecimal(-1, -2147483648));
    }
}
