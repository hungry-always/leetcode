package topic101_200;

import org.junit.jupiter.api.Test;

public class Solution165 {
    public int compareVersion(String version1, String version2) {
        version1 = deleteZero(version1);
        version2 = deleteZero(version2);
        return 1;
    }

    private String deleteZero(String s) {
        String[] split = s.split("\\.");
        for (int i = 0; i < split.length; i++) {
            StringBuilder sb = new StringBuilder(split[i]);
            while (sb.charAt(0) == '0' && sb.length() != 1) {
                sb.deleteCharAt(0);
            }
            split[i] = sb.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            sb.append(split[i]);
            if (i != split.length - 1) {
                sb.append(".");
            }
        }
        while (sb.length() >= 2 && sb.charAt(sb.length()) == '0' && sb.charAt(sb.length() - 1) == '.') {
            sb.delete(sb.length() - 2, sb.length() - 1);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String s = "1.000.000.000";
        System.out.println(deleteZero(s));
    }
}
