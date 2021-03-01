package everyDay.date_2021.Feb;

import org.junit.jupiter.api.Test;

public class Solution2_27 {
    public int longestSubstring(String s, int k) {
        return longestSubstring(s,k, 0, s.length() - 1);
    }

    private int longestSubstring(String s, int k, int left, int right) {
        if (left > right) {
            return 0;
        }
        int size = 0, count = 0;
        int[] numbers = new int[26];
        for (int i = left; i <= right; i++) {
            int index = s.charAt(i) - 97;
            if (numbers[index] == 0) {
                size++;
            }
            numbers[index]++;
            if (numbers[index] == k) {
                count++;
            }
        }
        if (size == count) {
            return right-left+1;
        }
        int mid1 = right;
        for (int i = left; left <= right; i++) {
            if (numbers[s.charAt(i) - 97] < k) {
                mid1 = i;
                break;
            }
        }
        int mid2 = -1;
        for (int i = right; i >= left; i--) {
            if (numbers[s.charAt(i) - 97] < k) {
                mid2 = i;
                break;
            }
        }
        int max = Math.max(longestSubstring(s, k, left, mid1-1), longestSubstring(s, k, mid2+1, right));
        max = Math.max(longestSubstring(s, k, mid1+1, mid2-1), max);
        return max;
    }


    @Test
    public void test() {
        System.out.println(longestSubstring("baaabcb", 3));
    }
}
