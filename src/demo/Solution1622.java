package demo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution1622 {
    @Test
    public void test() {
        Fancy fancy = new Fancy();
        fancy.append(2);
        fancy.addAll(3);
        fancy.append(7);
        fancy.multAll(2);
        int index = fancy.getIndex(0);
        System.out.println(index);
        System.out.println((int) (1e9 + 7));
    }
}
class Fancy {
    final int mod = (int) (1e9 + 7);
    List<Integer> list;
    List<Integer> countList;
    List<int[]> statusList;
    public Fancy() {
        list = new ArrayList<>();
        countList = new ArrayList<>();
        statusList = new ArrayList<>();
    }

    public void append(int val) {
        list.add(val);
        countList.add(statusList.size());
    }

    public void addAll(int inc) {
        statusList.add(new int[]{1, inc});
    }

    public void multAll(int m) {
        statusList.add(new int[]{0, m});
    }

    public int getIndex(int idx) {
        if (idx >= list.size()) {
            return -1;
        }
        long num = list.get(idx);
        Integer index = countList.get(idx);
        for (int i = index; i < statusList.size(); i++) {
            int[] status = statusList.get(i);
            if (status[0] == 1) {
                num += status[1];
            } else {
                num *= status[1];
            }
            num %= mod;
        }
        list.set(idx, (int)num);
        countList.set(idx, statusList.size());
        return (int) num;
    }

}
