package topic101_200;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution149 {
    public int maxPoints(int[][] points) {
        Map<String, Set<int[]>> map = new HashMap<>();
        for (int[] point : points) {
            Set<int[]> set = map.getOrDefault(point[0] + "", new HashSet<>());
            set.add(point);
            map.put(point[0] + "", set);
        }
        for (int i = 0; i < points.length; i++) {
            int[] point1 = points[i];
            for (int j = i; j < points.length; j++) {
                int[] point2 = points[j];
                if (point1[0] != point2[0]) {
                    int i1 = point1[1] - point2[1];
                    int i2 = point1[0] - point2[0];
                    int i3 = point1[0] * point2[1] - point2[0] * point1[1];
                    String k = generateStr(i1, i2);
                    String b = generateStr(i2, i3);
                    String key = k + "#" + b;
                    Set<int[]> set = map.getOrDefault(key, new HashSet<>());
                    set.add(point1);
                    set.add(point2);
                    map.put(key, set);
                }
            }
        }
        int max = 0;
        for (Set<int[]> value : map.values()) {
            max = Math.max(max, value.size());
        }
        return max;
    }

    public String generateStr(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            return 0 + "";
        }
        boolean b = num1 < 0 ^ num2 < 0;
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        int commonDivisor = getCommonDivisor(num1, num2);
        String s = num1 / commonDivisor + "=" + num2 / commonDivisor;
        return b ? s : "-" + s;
    }

    public int getCommonDivisor(int num1, int num2) {
        while (true) {
            if (num1 >= num2) {
                num1 %= num2;
                if (num1 == 0) {
                    return num2;
                }
            } else {
                num2 %= num1;
                if (num2 == 0) {
                    return num1;
                }
            }
        }
    }

    @Test
    public void test() {
//        int[][] points = {{3, 10}, {0, 2}, {0, 2}, {3, 10}};
        int[][] points = {{0,-70}, {21,10}, {42, 90},{-42,-230}};
        int i = maxPoints(points);
        System.out.println(i);
        System.out.println("===============");
        System.out.println(getCommonDivisor(36, 28));
    }
}
