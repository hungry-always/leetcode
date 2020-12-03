package everyDay;

import java.util.HashMap;
import java.util.Map;

public class Solution767 {
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder(S);
        char before = '0';
        for (int i = sb.length() - 1; i > 0; i--) {
            char c = sb.charAt(i);
            if (c == before) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println((int)('a'));// 97
        System.out.println((int)('z'));// 122
        System.out.println((int)('A'));// 65
        System.out.println((int)('Z'));// 90
    }
}
