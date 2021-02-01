///*
//package everyWeek.fight20Day.weekDouble22;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Solution1386 {
//    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
//        int count = 2;
//        boolean[][] dp = new boolean[n][10];
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int[] reservedSeat : reservedSeats) {
//            dp[reservedSeat[0]][reservedSeat[1]] = true;
//            List<Integer> list = map.getOrDefault(reservedSeat[0], new ArrayList<>());
//            list.add(reservedSeat[1]);
//            map.put(reservedSeat[0], list);
//        }
//        boolean[] check = new boolean[n];
//        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
//            List<Integer> value = entry.getValue();
//            if (value.size() == 2 && (value.get(0) == 0 || value.get(0) == 10)) {
//
//            }
//        }
//        return 0;
//    }
//}
//*/
