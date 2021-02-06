package everyDay;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 424题双指针使用
 */
public class Solution2_2 {

    @Test
    public void test() {
        System.out.println(characterReplacement("ABABASDASFASDFASDFASDFQWEWEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE", 20));
    }

    Map<Character, Integer> map;
    Map<Integer, Set<Character>> mapSet;

    public int characterReplacement(String s, int k) {
        int maxCount = 0;
        mapSet = new HashMap<>();
        map = new HashMap<>();
        int start = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            asc(c);
            maxCount = Math.max(maxCount, map.get(c));
            if (i - start - maxCount + 1 <= k) {
                result = i - start + 1;
            } else {
                desc(s.charAt(start));
                start++;
            }
            if (mapSet.get(maxCount) == null || mapSet.get(maxCount).size() == 0) {
                maxCount--;
            }
        }
        return result;
    }

    private void asc(char c) {
        Integer count = map.getOrDefault(c, 0);
        if (mapSet.get(count) != null) {
            mapSet.get(count).remove(c);
        }
        count++;
        map.put(c, count);
        Set<Character> set = mapSet.getOrDefault(count, new HashSet<>());
        set.add(c);
        mapSet.put(count, set);
    }

    private void desc(char c) {
        Integer count = map.get(c);
        mapSet.get(count).remove(c);
        count--;
        if (count == 0) {
            map.remove(c);
        } else {
            map.put(c, count);
            mapSet.get(count).add(c);
        }
    }

    public int longestOnes(int[] A, int K) {
        int count0 = 0;
        int count1 = 0;
        int left = 0;
        int right = 0;
        int result = 0;
        while (right <= A.length - 1) {
            if (A[right] == 1) {
                count1++;
            } else {
                count0++;
            }
            if (count0 > K) {
                if (A[left] == 0) {
                    count0--;
                } else {
                    count1--;
                }
                left++;
            }
            result = Math.max(count1 + count0, result);
            right++;
        }
        return result;
    }

    @Test
    public void test2() {
        System.out.println(equalSubstring("abcd", "cdef", 3));
    }
    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int[] nums = new int[length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int result = 0;
        int cost = 0;
        int left = 0, right = 0;
        while (right <= length - 1) {
            if (cost > maxCost) {
                cost -= nums[left];
                left++;
            } else {
                cost += nums[right];
                right++;
            }
            if (cost <= maxCost) {
                result = Math.max(result, right - left);
            }
        }
        return result;
    }
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            Set<Integer> set = map.getOrDefault(c, new HashSet<>());
            set.add(i);
            map.put(c, set);
        }
        Set<Integer> set = map.get(s1.charAt(0));
        if (set == null) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>(set);
        for (int i = 1; i < s1.length(); i++) {
            int size = queue.size();
            Set<Integer> set1 = map.get(s1.charAt(i));
            if (set1 != null && size > 0) {
                Integer poll = queue.poll();
                if (set1.contains(poll + 1)) {
                    queue.add(poll + 1);
                }
            }
            if (queue.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test3() {
        System.out.println(checkInclusion("ab", "eidbooo"));
    }
}
