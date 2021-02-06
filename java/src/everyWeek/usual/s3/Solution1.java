package everyWeek.usual.s3;

import org.junit.jupiter.api.Test;

public class Solution1 {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder(number);
        for (int i = sb.length(); i > 0; i--) {
            if (sb.charAt(i - 1) == '-' || sb.charAt(i - 1) == ' ') {
                sb.deleteCharAt(i - 1);
            }
        }
        int length = sb.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= length / 3; i++) {
            int index = 3 * i;
            if (length - index <= 4) {
                if (length - index == 4) {
                    result.append(sb.substring(index, index + 2) + "-" + sb.substring(index + 2));
                } else {
                    result.append(sb.substring(index));
                }
                break;
            } else {
                result.append(sb.substring(index, index + 3)+"-");
            }
        }
        return result.toString();
    }

    @Test
    public void test() {
        String number = "123 4-5678";
        System.out.println(reformatNumber(number));
    }
}
