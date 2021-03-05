package everyDay.date_2021.Mar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3_03 {
    int check = 0;
    public int[] countBits(int num) {
        check = num;
        int[] resultArr = new int[num + 1];
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int grades = 1;
        while (grades <= num) {
            count++;
            list.add(grades);
            grades *= 2;
        }
        for (int i = 1; i <= count; i++) {
            Set<Integer> sumSet = new HashSet<>();
            sumSet.add(0);
            Set<Integer> set = getCountSet(i, 0, list, sumSet);
            for (Integer index : set) {
                if (index <= num) {
                    resultArr[index] = i;
                }
            }
        }
        return resultArr;
    }

    private Set<Integer> getCountSet(int i, int start, List<Integer> list, Set<Integer> sumSet) {
        Set<Integer> countSet = new HashSet<>();
        if (i == 0) {
            return sumSet;
        }
        if (start >= list.size()) {
            return countSet;
        }
        Integer num = list.get(start);
        start++;
        Set<Integer> set1 = new HashSet<>(sumSet);
        Set<Integer> set2 = new HashSet<>();
        for (Integer integer : set1) {
            if (integer + num <= check) {
                set2.add(integer + num);
            }
        }
        countSet.addAll(getCountSet(i - 1, start, list, set2));
        countSet.addAll(getCountSet(i, start, list, set1));
        return countSet;
    }

    @Test
    public void test() {
        int[] ints = countBits(3);
        System.out.println(ints);
    }
}
