package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Set;

/**
 * 字符串转换整数 (atoi)
 */
public class Solution08 {
    public int myAtoi(String s) {
        Set<Character> numSet = Set.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        Set<Character> signSet = Set.of('-', '+');
        // 记录是否有正负号
        boolean negative = false;
        boolean isFindSymbol = false;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (signSet.contains(c)) {
                if (isFindSymbol) {
                    break;
                } else {
                    if (c == '-') {
                        negative = true;
                    }
                    isFindSymbol = true;
                }
            } else if (numSet.contains(c)) {
                list.add(c - '0');
            } else if (c == ' ' ) {
                continue;
            } else {
                break;
            }
        }
        while (!list.isEmpty()) {
            if (list.getFirst() == '0') {
                list.removeFirst();
            } else {
                break;
            }
        }
        if (list.size() >= 12) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        long result = 0;
        for (Integer num : list) {
            result = result * 10 + num;
        }
        if (negative) {
            result = -result;
        }
        if (result >= (long) Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result <= (long) Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }

    @Test
    public void test() {
        System.out.println(myAtoi("+1"));
        System.out.println(myAtoi("   -1123u3761867"));
    }
}
