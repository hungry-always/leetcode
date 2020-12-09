package topic101_200;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三角路径和
 */
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int tSize = triangle.size();
        for (int i = 1; i < tSize; i++) {
            List<Integer> list = triangle.get(i);
            List<Integer> list1 = triangle.get(i - 1);
            int size = list.size();
            for (int j = 0; j < size; j++) {
                if (j == 0) {
                    list.set(j, list.get(j) + list1.get(j));
                } else if (j == size - 1) {
                    list.set(j, list.get(j) + list1.get(j - 1));
                } else {
                    Integer a = list1.get(j - 1);
                    Integer b = list1.get(j);
                    list.set(j, list.get(j) + Math.min(a, b));
                }
            }
        }
        List<Integer> list = triangle.get(tSize - 1);
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i));
        }
        return min;
    }

    @Test
    public void test() {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(2));
        lists.add(Arrays.asList(3,4));
        lists.add(Arrays.asList(6,5,7));
        lists.add(Arrays.asList(4,1,8,3));
        System.out.println(minimumTotal(lists));
    }
}
