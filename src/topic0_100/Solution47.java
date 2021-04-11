package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        permuteUniqueSub(lists, new LinkedList<Integer>(), map);
        return lists;
    }

    private void permuteUniqueSub(List<List<Integer>> lists, List<Integer> list, Map<Integer, Integer> map) {
        if (map.isEmpty()) {
            lists.add(list);
            return;
        }
        for (Integer key : map.keySet()) {
            LinkedList<Integer> subList = new LinkedList<>(list);
            subList.add(key);
            HashMap<Integer, Integer> subMap = new HashMap<>(map);
            subMap.put(key, subMap.get(key) - 1);
            if (subMap.get(key) == 0) {
                subMap.remove(key);
            }
            permuteUniqueSub(lists, subList, subMap);
        }
    }

    @Test
    public void test() {
        int[] ints = {1, 3, 2};
        List<List<Integer>> lists = permuteUnique(ints);
        System.out.println(lists);
    }
}
