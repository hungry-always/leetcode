package everyDay;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution547 {
    public int findCircleNum(int[][] isConnected) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    List<Integer> orDefault1 = map.getOrDefault(i, new LinkedList<>());
                    List<Integer> orDefault2 = map.getOrDefault(j, new LinkedList<>());
                    orDefault1.add(j);
                    orDefault2.add(i);
                    map.put(i, orDefault1);
                    map.put(j, orDefault2);
                    set.add(i);
                    set.add(j);
                }
            }
        }
        int count = 0;
        List<Integer> list = new ArrayList<>(set);
        for (Integer s : list) {
            if (set.contains(s)) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(s);
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    if (set.contains(poll)) {
                        set.remove(poll);
                        queue.addAll(map.get(poll));
                    }
                }
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        String str = "[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]";
        JSONArray jsonArray = JSONUtil.parseArray(str);
        List<int[]> list = jsonArray.toList(int[].class);
        int[][] ints = list.toArray(new int[][]{});
        System.out.println(ints);
        int circleNum = findCircleNum(ints);
        System.out.println(circleNum);
    }
}
