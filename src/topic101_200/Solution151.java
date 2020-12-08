package topic101_200;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution151 {
    public String reverseWords(String s) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                int start = i;
                while (i < s.length()&&s.charAt(i) != ' ') {
                    i++;
                }
                list.add(s.substring(start, i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size()-1; i >= 0; i--) {
            if (i != list.size()-1) {
                sb.append(" ");
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(reverseWords("  hello world!  "));
    }
}
