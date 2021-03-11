package everyDay.date_2021.Mar;

import org.junit.jupiter.api.Test;

public class Solution3_09 {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0; i < sb.length(); i++) {
            char oldC = (i - 1 >= 0) ? sb.charAt(i - 1) : '0';
            if (oldC == sb.charAt(i)) {
                sb.deleteCharAt(i);
                sb.deleteCharAt(i - 1);
                i -= 2;
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String s = "ccaac";
        String s1 = removeDuplicates(s);
        System.out.println(s1);
    }
}
