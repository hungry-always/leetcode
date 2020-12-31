package topic101_200;

import org.junit.jupiter.api.Test;

public class Solution165 {
    public int compareVersion(String version1, String version2) {
        version1 = deleteZero(version1);
        version2 = deleteZero(version2);
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        for (int i = 0; i < Math.min(split1.length, split2.length); i++) {
            if (Integer.valueOf(split1[i]) > Integer.valueOf(split2[i])) {
                return 1;
            } else if (Integer.valueOf(split2[i]) > Integer.valueOf(split1[i])) {
                return -1;
            }
        }
        if (split1.length == split2.length) {
            return 0;
        } else if (split1.length > split2.length) {
            return 1;
        } else {
            return -1;
        }
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
        while (sb.length() >= 2 && sb.charAt(sb.length()-1) == '0' && sb.charAt(sb.length() - 2) == '.') {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String version1 = "1.0.1";
        String version2 = "1";
        int i = compareVersion(version1, version2);
        System.out.println(i);
    }
}
