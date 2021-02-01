//package everyWeek.fight20Day.week181;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.*;
//
//public class Solution1391 {
//    final char zuo = '左';
//    final char you = '右';
//    final char shang = '上';
//    final char xia = '下';
//    Map<Integer, char[]> inMap;
//    Map<Character, Set<Integer>> map = new HashMap<>();
//
//    public boolean hasValidPath(int[][] grid) {
//        inMap = Map.of(
//                1, new char[]{zuo, you},
//                2, new char[]{shang, xia},
//                3, new char[]{zuo, xia},
//                4, new char[]{you, xia},
//                5, new char[]{zuo, shang},
//                6, new char[]{you, shang}
//        );
//        for (Map.Entry<Integer, char[]> entry : inMap.entrySet()) {
//            for (Character c : entry.getValue()) {
//                Set<Integer> set = map.getOrDefault(c, new HashSet<>());
//                set.add(entry.getKey());
//                map.put(c, set);
//            }
//        }
//        char[] chars = inMap.get(grid[0][0]);
//        boolean a = doJob(grid, inMap, map, chars[0]);
//        boolean b = doJob(grid, inMap, map, chars[1]);
//        return a || b;
//    }
//
//    private boolean doJob(int[][] grid, Map<Integer, char[]> inMap, Map<Character, Set<Integer>> map, char doChar) {
//        boolean[][] dp = new boolean[grid.length][grid[0].length];
//        int i = 0, j = 0;
//        while (i < grid.length && i >= 0 && j < grid[0].length && j >= 0) {
//            int doGrid = grid[i][j];
//            if (dp[i][j]) {
//                return false;
//            }
//            dp[i][j] = true;
//            char[] chars = inMap.get(doGrid);
//            if (chars[0] != doChar && chars[1] != doChar) {
//                return false;
//            }
//            if (i == grid.length - 1 && j == grid[0].length - 1) {
//                return true;
//            }
//            char temp = (chars[0] == doChar) ? chars[1] : chars[0];
//            switch (temp) {
//                case zuo:
//                    doChar = you;
//                    j--;
//                    break;
//                case you:
//                    doChar = zuo;
//                    j++;
//                    break;
//                case shang:
//                    doChar = xia;
//                    i--;
//                    break;
//                case xia:
//                    doChar = shang;
//                    i++;
//                    break;
//                default:
//            }
//        }
//        return false;
//    }
//
//    @Test
//    public void test() {
//        System.out.println(hasValidPath(new int[][]{{2, 4, 3}, {6, 5, 2}}));
//        System.out.println(hasValidPath(new int[][]{{3, 5, 1, 4}, {1, 4, 5, 1}}));
//    }
//}
