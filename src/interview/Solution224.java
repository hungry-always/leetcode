package interview;

import java.util.Stack;

/**
 * 基本计算器1
 */
public class Solution224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        stack.push(sign);
        int result = 0;
        int i = 0;
        int n = s.length();
        while (true) {
            if (!(i < n)) break;
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int number = c - '0';
                while (i + 1 < n) {
                    number = ((number * 10) + s.charAt(i + 1)) - '0';
                    i++;
                }
                result += number * sign;
            } else if (c == '(') {

            }
        }
        return 0;
    }
}
