package classic;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class 排序数组 {
    public int[] sortArray(int[] nums) {
        // 快速排序
        sortPortArray(0, nums.length - 1, nums);
        return nums;
    }

    private void sortPortArray(int start, int end, int[] nums) {
        if (start >= end) {
            return;
        }
        if (end - start == 1) {
            if (nums[start] > nums[end]) {
                swap(start, end, nums);
            }
            return;
        }
        int random = getRandom(start, end);
        int num = nums[random];
        swap(random, end, nums);
        int point = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] < num) {
                swap(point, i, nums);
                point++;
            }
        }
        System.out.print("");
        sortPortArray(start, start + point - 1, nums);
        sortPortArray(start + point, end, nums);

    }

    void swap(int index1, int index2, int[] nums) {
        int num = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = num;
    }

    /**
     * 得到start到end的随机数
     *
     * @param start
     * @param end
     * @return
     */
    int getRandom(int start, int end) {
        Random random = new Random();
        int i = random.nextInt(end - start + 1);
        return i + start;
    }

    @Test
    public void test() {
        int[] nums = {2, 8, 7, 1, 3, 9, 4, 1, 4};
        sortArray(nums);
        for (int num : nums) {
            System.out.print(num);
        }
    }
}
