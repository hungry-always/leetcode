package everyDay.date_2021.Mar;

import commmon.ArraysUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution03_15 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int up = 0, down = matrix.length - 1,
                left = 0, right = matrix[0].length - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            up++;
            if (up > down || left > right) {
                break;
            }
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (up > down || left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            down--;
            if (up > down || left > right) {
                break;
            }
            for (int i = down; i >= up; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            if (up > down || left > right) {
                break;
            }
        }
        return list;
    }

    @Test
    public void test() {
        int[][] ints = ArraysUtils.generateTwo("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]");
        List<Integer> list = spiralOrder(ints);
        System.out.println(list);
    }
}
