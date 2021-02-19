package everyWeek.s11;

import org.junit.jupiter.api.Test;

public class Solution03 {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int start1 = 0;
        int start2 = 0;
        int l1 = word1.length();
        int l2 = word2.length();
        while (start1 <= l1 - 1 || start2 <= l2 - 1) {
            if (start1 > l1 - 1) {
                sb.append(word2.substring(start2));
                break;
            }
            if (start2 > l2 - 1) {
                sb.append(word1.substring(start1));
                break;
            }
            int end1 = getEnd(word1, start1);
            int end2 = getEnd(word2, start2);
            if (compare(word1, start1, word2, start2)) {
                sb.append(word1, start1, end1+1);
                start1 = end1 + 1;
            } else {
                sb.append(word2, start2, end2+1);
                start2 = end2 + 1;
            }
        }
        return sb.toString();
    }

    private boolean compare(String word1, int start1, String word2, int start2) {
        char c1 = word1.charAt(start1);
        char c2 = word2.charAt(start2);
        if (c1 != c2) {
            return c1 > c2;
        } else {
            while (true) {
                if (start1 >= word1.length() && start2 >= word2.length()) {
                    return true;
                }
                if (start1 < word1.length() && start2 < word2.length()) {
                    if (word1.charAt(start1) == word2.charAt(start2)) {
                        start1++;
                        start2++;
                    } else {
                        return word1.charAt(start1) > word2.charAt(start2);
                    }
                } else {
                    if (start1 >= word1.length()) {
                        if (c1 == word2.charAt(start2)) {
                            start2++;
                        } else {
                            return c1 > word2.charAt(start2);
                        }
                    } else {
                        if (c2 == word1.charAt(start1)) {
                            start1++;
                        } else {
                            return word1.charAt(start1) > c2;
                        }
                    }
                }
            }
        }
    }

    private int getEnd(String word, int start1) {
        char c = word.charAt(start1);
        for (int i = start1; i < word.length(); i++) {
            if (word.charAt(i) != c) {
                return i - 1;
            }
        }
        return word.length() - 1;
    }

    @Test
    public void test() {
        String s = largestMerge("ddddddddydvdddvvdddf", "yydyyyyyyfyydyyfyyyydfyd");
        System.out.println(s);
    }

    /**
     * "ddddddddydvdddvvdddf"
     * "yydyyyyyyfyydyyfyyyydfyd"
     * "yydyyyyyyfyydyyfyyyydfydddddddddydvdddvvdddf"
     * "yydyyyyyyfyydyyfyyyydfyddddddddydvdddvvdddfd"
     */
}
