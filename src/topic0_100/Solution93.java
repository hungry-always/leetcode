package topic0_100;

import java.util.LinkedList;
import java.util.List;

/**
 * 复原ip
 */
public class Solution93 {
    List<String> list = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        restoreIpAddresses(s, 0, 0, "");
        return list;
    }

    private void restoreIpAddresses(String s, int index, int count, String str) {
        int n = s.length();
        if (count == 4) {
            if (index >= n) {
                list.add(str.substring(0, str.length() - 1));
            }
            return;
        }
        int no = n - index;
        if (no >= 1) {
            restoreIpAddresses(s, index + 1, count + 1, str + s.charAt(index) + ".");
        }
        if (no >= 2) {
            String sub = s.substring(index, index + 2);
            if (sub.charAt(0) != '0') {
                restoreIpAddresses(s, index + 2, count + 1, str + sub + ".");
            }
        }
        if (no >= 3) {
            String sub = s.substring(index, index + 3);
            if (sub.charAt(0) != '0'&&Integer.parseInt(sub)<=255) {
                restoreIpAddresses(s, index + 3, count + 1, str + sub + ".");
            }
        }
    }
}
