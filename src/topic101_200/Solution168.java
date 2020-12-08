package topic101_200;

import org.junit.jupiter.api.Test;

public class Solution168 {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while (n != 0) {
            int i = (n - 1) % 26;
            n =(n-1)/26;
            char c = (char) (65 + i);
            sb.append(c);
        }
        sb.reverse();
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(convertToTitle(28));
    }
}
