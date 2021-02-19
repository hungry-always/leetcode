//package hard;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
//public class Solution08_12 {
//    Map<Integer, String> map = new HashMap<>();
//    List<List<String>> lists = new LinkedList<>();
//    public List<List<String>> solveNQueens(int n) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(".".repeat(Math.max(0, n)));
//        for (int i = 0; i < n; i++) {
//            sb.setCharAt(i, 'Q');
//            map.put(i, sb.toString());
//            sb.setCharAt(i, '.');
//        }
//        int c1 = 0, i1 = 0, i2 = 0;
//        solveNQueens(0,new LinkedList<String>(), n, c1, i1, i2);
//    }
//
//    private void solveNQueens(int i, List<String> list, int n, int c1, int i1, int i2) {
//
//    }
//
//}
