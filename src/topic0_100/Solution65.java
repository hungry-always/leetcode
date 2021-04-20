package topic0_100;

import org.junit.jupiter.api.Test;

public class Solution65 {
    public boolean isNumber(String s) {
        int indexE = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'e' || c == 'E') {
                if (indexE == -1) {
                    indexE = i;
                } else {
                    return false;
                }
            }
        }
        if (indexE == -1) {
            return isDecimal(s) != -1;
        }
        return isDecimal(s.substring(0, indexE)) != -1
                && isDecimal(s.substring(indexE + 1)) == 0;
    }

    private int isDecimal(String s) {
        int count = 0;
        boolean isSign = false;
        boolean isPoint = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-' || c == '+') {
                if (isSign) {
                    return -1;
                } else {
                    isSign = true;
                }
            } else if (Character.isDigit(c)) {
                count++;
            } else if (c == '.') {
                isPoint = true;
            } else {
                return -1;
            }
        }
        if (count == 0) {
            return -1;
        } else {
            return (isPoint) ? 1 : 0;
        }
    }

    @Test
    public void test() {
//        System.out.println(isNumber("0"));
//        System.out.println(isNumber("e"));
//        System.out.println(isNumber("."));
//        System.out.println(isNumber(".1"));
        System.out.println(isNumber("-123.456e789"));
        System.out.println(isNumber("1e"));
    }
}
