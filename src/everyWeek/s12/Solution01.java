package everyWeek.s12;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class Solution01 {
    public String longestNiceSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> twoSet = new HashSet<>();
        int start = -1, end = -2;
        for (int i = 0; i < s.length(); i++) {
            set.clear();
            twoSet.clear();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c >= 'a' && c <= 'z') {
                    set.add(c);
                } else {
                    set.add((char) (c + 32));
                }
                twoSet.add(c);
                if (twoSet.size() == 2 * set.size() && j - i > end - start) {
                    end = j;
                    start = i;
                }
            }
        }
        return (start == -1) ? "" : s.substring(start, end+1);
    }

    @Test
    public void test() {
//        System.out.println(Integer.valueOf('a'));
//        System.out.println(Integer.valueOf('z'));
//        System.out.println(Integer.valueOf('A'));
//        System.out.println(Integer.valueOf('Z'));
        System.out.println(longestNiceSubstring("YazaAay"));
        System.out.println(longestNiceSubstring("Bb"));
        System.out.println(longestNiceSubstring("c"));
        System.out.println(longestNiceSubstring("dDzeE"));
    }
}
