//package topic301_400;
//
//import java.util.*;
//
//public class Solution399 {
//    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        double[] result = new double[queries.size()];
//        Map<String, Map<String, Double>> map = new HashMap<>();
//        for (int i = 0; i < equations.size(); i++) {
//            List<String> list = equations.get(i);
//            String s1 = list.get(0);
//            String s2 = list.get(1);
//            Map<String, Double> map1 = map.getOrDefault(s1, new HashMap<>());
//            map1.put(s2, values[i]);
//            map.put(s1, map1);
//            Map<String, Double> map2 = map.getOrDefault(s2, new HashMap<>());
//            map2.put(s1, values[i]);
//            map.put(s2, map2);
//        }
//        Queue<Sub> queue = new LinkedList<>();
//        for (int i = 0; i < queries.size(); i++) {
//            List<String> list = queries.get(i);
//            String s1 = list.get(0);
//            String s2 = list.get(1);
//            if (s1 == s2) {
//                result[i] = 1;
//            } else {
//                queue.add()
//            }
//        }
//        return result;
//    }
//    class Sub{
//        double value;
//        int index;
//        String str1;
//        String str2;
//
//        public Sub(double value, int index, String str1,String str2) {
//            this.value = value;
//            this.index = index;
//            this.str1 = str1;
//            this.str2 = str2;
//        }
//    }
//}
