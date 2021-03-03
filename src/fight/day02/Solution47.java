package fight.day02;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 全排序II
 */
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        permuteUnique(map, new LinkedList<>());
        return lists;
    }

    private void permuteUnique(Map<Integer, Integer> map, List<Integer> list) {
        
    }
}
