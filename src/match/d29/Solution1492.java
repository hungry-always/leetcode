package match.d29;

import java.util.ArrayList;
import java.util.List;

public class Solution1492 {
    public int kthFactor(int n, int k) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int count = 1;
        while (n / count >= count) {
            if (n % count == 0) {
                list1.add(count);
                if (n % count != count) {
                    list2.add(count);
                }
                count++;
            }
        }
        if (k <= list1.size()) {
            return list1.get(k - 1);
        } else {
            return list2.get(list2.size() + list1.size() - k);
        }
    }
}
