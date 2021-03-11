package interview;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 基本计算器2
 */
public class Solution227 {
    private final char plus = '+';
    private final char less = '-';
    private final char multiply = '*';
    private final char except = '/';

    public int calculate(String s) {
        List<Long> numberList = new ArrayList<>();
        List<Character> charList = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                long number = c - '0';
                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    number = number* 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                numberList.add(number);
            } else if (c != ' ') {
                charList.add(c);
            }
        }
        for (int i = 0; i < charList.size(); i++) {
            Character c = charList.get(i);
            if (c == multiply || c == except) {
                numberList.set(i, doCalculate(c, numberList.get(i), numberList.get(i + 1)));
                numberList.remove(i + 1);
                charList.remove(i);
                i--;
            }
        }
        long result = numberList.get(0);
        for (int i = 0; i < charList.size(); i++) {
            result = doCalculate(charList.get(i), result, numberList.get(i + 1));
        }
        return (int) result;
    }

    private long doCalculate(char c, long i1, long i2) {
        switch (c) {
            case plus:
                return i1 + i2;
            case less:
                return i1 - i2;
            case multiply:
                return i1 * i2;
            case except:
                return i1 / i2;
            default:
                return -1;
        }
    }

    @Test
    public void test() {
        String s = "32+212*212/1213";
        int calculate = calculate(s);
        System.out.println(calculate);
    }
}
