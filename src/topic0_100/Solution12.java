package topic0_100;

import org.junit.jupiter.api.Test;

public class Solution12 {
    StringBuffer sb = new StringBuffer();
    public String intToRoman(int num) {
        int divisor = 1000;
        while (num != 0) {
            int quotient = num / divisor;
            num %= divisor;
            if (quotient != 0) {
                switch (divisor) {
                    case 1000:
                        for (int i = 0; i < quotient; i++) {
                            sb.append("M");
                        }
                        break;
                    case 100:
                        addNumber(quotient, 'C', 'D', 'M');
                        break;
                    case 10:
                        addNumber(quotient, 'X', 'L', 'C');
                        break;
                    case 1:
                        addNumber(quotient, 'I', 'V', 'X');
                        break;
                }
            }
            divisor /= 10;
        }
        return sb.toString();
    }
    void addNumber(int number, char c1, char c2, char c3) {
        if (number == 9) {
            sb.append(c1).append(c3);
        } else if (number <= 8 && number >= 5) {
            sb.append(c2);
            for (int i = 0; i < number - 5; i++) {
                sb.append(c1);
            }
        } else if (number == 4) {
            sb.append(c1).append(c2);
        } else if (number >= 1 && number <= 3) {
            for (int i = 0; i < number; i++) {
                sb.append(c1);
            }
        }
    }

    @Test
    public void test() {
        System.out.println(intToRoman(3));//III
    }
}
