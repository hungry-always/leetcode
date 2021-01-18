package everyWeek.usual.s6;

import org.junit.jupiter.api.Test;

public class Solution1 {
    public static final String STRING = "aeiouAEIOU";
    public boolean halvesAreAlike(String s) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (STRING.contains(s.charAt(i) + "")) {
                if (i < s.length() / 2) {
                    count1++;
                } else {
                    count2++;
                }
            }
        }
        return count1 == count2;
    }

    @Test
    public void test() {
        boolean book = halvesAreAlike("book");
        System.out.println(book);
    }
}
