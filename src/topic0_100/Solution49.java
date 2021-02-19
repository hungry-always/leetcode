package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 字母异位词分组
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> lists = new ArrayList<>();
        for (String str : strs) {
            String encryptionStr = encryptionStr(str);
            List<String> list = map.get(encryptionStr);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(encryptionStr, list);
        }
        return new ArrayList<>(map.values());
    }
    String encryptionStr(String str) {
        int[] ints = new int[26];
        for (int i = 0; i < str.length(); i++) {
            ints[str.charAt(i) - 97]++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ints.length; i++) {
            sb.append(ints[i]+"#");
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String[] strings = {"tin","ram","zip","cry","pus","jon","zip","pyx"};
        System.out.println(groupAnagrams(strings));
    }

    public static void main(String[] args) {
        System.out.println('z'-96);
    }
}
