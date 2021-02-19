package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.*;

class Solution46 {
    Map<String, List<List<Integer>>> map = new HashMap<>();

    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }
        return permuteList(set);
    }

    private List<List<Integer>> permuteList(Set<Integer> set) {
        String s = set.toString();
        if (map.get(s) != null) {
            return map.get(s);
        }
        List<List<Integer>> lists = new ArrayList<>();
        if (set.isEmpty()) {
            lists.add(new ArrayList<>());
        }
        for (Integer key : set) {
            Set<Integer> set1 = new HashSet<>(set);
            set1.remove(key);
            List<List<Integer>> list = permuteList(set1);
            for (List<Integer> integerList : list) {
                List<Integer> subList = new ArrayList<>(integerList);
                subList.add(key);
                lists.add(subList);
            }
        }
        map.put(s, lists);
        return lists;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute1(nums);
        System.out.println(permute);
    }


    /**
     * 回溯法
     */
    public List<List<Integer>> permute1(int[] nums) {
        return permute(nums, 0, nums.length - 1);
    }

    private List<List<Integer>> permute(int[] nums, int start, int end) {
        List<List<Integer>> lists = new LinkedList<>();
        if (start > end) {
            lists.add(new ArrayList<>());
            return lists;
        } else if (start == end) {
            List<Integer> list = Arrays.asList(nums[start]);
            lists.add(list);
            return lists;
        }
        List<List<Integer>> permute1 = permute(nums, start, start);
        List<List<Integer>> permute2 = permute(nums, start + 1, end);
        for (List<Integer> per1 : permute1) {
            for (List<Integer> per2 : permute2) {
                List<Integer> list = new LinkedList<>(per1);
                list.addAll(per2);
                List<Integer> list2 = new LinkedList<>(per2);
                list2.addAll(per1);
                lists.add(list);
                lists.add(list2);
            }
        }
        return lists;
    }
}
