package everyDay;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution2_07 {
    public boolean checkPossibility(int[] nums) {
        boolean flag = false;
        int index = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (flag) {
                    return false;
                } else {
                    flag = true;
                    index = i + 1;
                }
            }
        }
        return !flag || (index == 1 || index == nums.length - 1) || (nums[index - 1] <= nums[index + 1]);
    }

    @Test
    public void test() {
        KthLargest kthLargest = new KthLargest(1,new int[]{});
        System.out.println(kthLargest.add(-3));
        System.out.println(kthLargest.add(-2));
        System.out.println(kthLargest.add(-4));
        System.out.println(kthLargest.add(0));
        System.out.println(kthLargest.add(4));
    }
}
class KthLargest {
    LinkedList<Integer> list;
    int k;

    public KthLargest(int k, int[] nums) {
        Arrays.sort(nums);
        list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }
        this.k = k;
    }

    public int add(int val) {
        if (list.isEmpty()) {
            list.add(val);
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (val < list.get(i)) {
                    list.add(i, val);
                    break;
                } else if (i == list.size() - 1) {
                    list.add(val);
                    break;
                }
            }
        }
        return list.get(list.size() - k);
    }
}
