package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        lists.add(new ArrayList<>());
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            List<Integer> subList = new ArrayList<>();
            int size = lists.size();
            for (Integer i = 1; i <= value; i++) {
                subList.add(key);
                for (int j = 0; j < size; j++) {
                    List list = new ArrayList(lists.get(j));
                    list.addAll(subList);
                    lists.add(list);
                }
            }
        }
        return lists;
    }

    @Test
    public void test() {
        int[] ints = {1, 2, 2};
        List<List<Integer>> lists = subsetsWithDup(ints);
        System.out.println(lists);
    }
}
