package topic0_100;

import org.junit.jupiter.api.Test;

public class Solution43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int l1 = num1.length();
        for (int i = l1; i > 0; i--) {
            int more = 0;
            int n = num1.charAt(i - 1) - '0';
            int l2 = num2.length();
            for (int j = l2; j > 0; j--) {
                int m = num2.charAt(j - 1) - '0';
                int nm = n * m + more;
                more = nm / 10;
                int k2 = nm % 10;
                int index = (l1 - i) + (l2 - j + 1);
                if (index > sb.length()) {
                    sb.append((char) (k2 + '0'));
                } else {
                    int i1 = sb.charAt(index - 1) + k2;
                    if (i1 <= '9') {
                        sb.setCharAt(index - 1, (char) i1);
                    } else {
                        more++;
                        sb.setCharAt(index - 1, (char) (i1 - 10));
                    }
                }
                if (j == 1&&more!=0) {
                    sb.append((char) (more + '0'));
                }
            }
        }
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(multiply("9133", "0"));
    }
}
