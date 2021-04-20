//package match.d24;
//
//import java.util.*;
//
//public class Solution1494 {
//    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
//        int[] countArr = new int[n];
//        int[] countZeroArr = new int[n];
//        boolean[] booArr = new boolean[n];
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        Map<Integer, List<Integer>> beMap = new HashMap<>();
//        for (int[] dependency : dependencies) {
//            int num = dependency[0];
//            int beNum = dependency[1];
//            List<Integer> list = map.getOrDefault(num, new ArrayList<>());
//            list.add(beNum);
//            map.put(num, list);
//            countArr[beNum]++;
//        }
//        List<Integer> zeroList = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if (countArr[i] == 0) {
//                zeroList.add(i);
//            }
//        }
//        for (Integer key : zeroList) {
//            for (Integer value : map.get(key)) {
//                countZeroArr[value]++;
//                List<Integer> orDefault = map.getOrDefault(value, new ArrayList<>());
//            }
//        }
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(i -> countZeroArr[i]));
//        for (int i = 0; i < n; i++) {
//            if (countArr[i] == countZeroArr[i]) {
//                queue.add(i);
//            }
//        }
//        while (!queue.isEmpty()) {
//            int count = k;
//            while (count > 0 && !queue.isEmpty()) {
//                Integer poll = queue.poll();
//
//            }
//        }
//    }
//}
