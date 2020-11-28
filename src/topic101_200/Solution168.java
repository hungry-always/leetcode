package topic101_200;

import org.junit.jupiter.api.Test;

public class Solution168 {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while (n != 0) {
            int remainder = n % 26;
            n /= 26;
            if (remainder == 0) {
                sb.append("Z");
            } else {
                sb.append((char) (remainder + 64));
            }
        }
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(convertToTitle(701));
    }
}
