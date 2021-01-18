package everyWeek.s9;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution3 {
    public int largestSubmatrix1(int[][] matrix) {
        int[] countArr = new int[matrix[0].length];
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            List<int[]> list = new ArrayList<>();
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    countArr[j]++;
                    list.add(new int[]{j, countArr[j]});
                    int min = Integer.MAX_VALUE;
                    for (int k = list.size()-1; k >= 0; k--) {
                        int[] ints = list.get(k);
                        min = Math.min(ints[1], min);
                        result = Math.max(result, (j - ints[0] + 1) * min);
                    }
                } else {
                    list.clear();
                    countArr[j] = 0;
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[][] ints = {{1,0,1,0,1}};
        int i = largestSubmatrix(ints);
        System.out.println(i);
//
//        String s = "1#2";
//        String[] split = s.split("#");
//        System.out.println(Integer.parseInt(split[0]));
//        System.out.println(Integer.parseInt(split[1]));
//        System.out.println(split[1]);
    }
    public int largestSubmatrix(int[][] matrix) {
        Map<Temp, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix[0].length; i++) {
            int index = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 1) {
                    for (int k = index; k <= j; k++) {
                        Temp temp = new Temp(k, j);
                        map.put(temp, map.getOrDefault(temp, 0) + 1);
                    }
                } else {
                    index = j + 1;
                }
            }
        }
        int result = 0;
        for (Map.Entry<Temp, Integer> entry : map.entrySet()) {
            Temp key = entry.getKey();
            int i = key.i2 - key.i1+1;
            result = Math.max(result, i * entry.getValue());
        }
        return result;
    }

    class Temp {
        int i1;
        int i2;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Temp)) {
                return false;
            }
            Temp temp = (Temp) o;
            return i1 == temp.i1 && i2 == temp.i2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i1, i2);
        }

        public Temp(int i1, int i2) {
            this.i1 = i1;
            this.i2 = i2;
        }
    }
}
