package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 寻找两个正序数组的中位数(要求时间复杂度为log(m+n))
 */
public class Solution04 {
    int start1, end1, start2, end2, k, size;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        end1 = length1 - 1;
        end2 = length2 - 1;
        size = length1 + length2;
        // 这个是要找的第一个数
        k = (size + 1) / 2;
        while (k > 1) {
            moveArray(nums1, nums2);
        }
        return getResult(nums1, nums2);
    }

    void moveArray(int[] nums1, int[] nums2) {
        int midNumber = k / 2 - 1;
        int index1 = Math.min(start1 + midNumber, end1);
        int index2 = Math.min(start2 + midNumber, end2);
        int value1 = (end1 >= start1) ? nums1[index1] : Integer.MAX_VALUE;
        int value2 = (end2 >= start2) ? nums2[index2] : Integer.MAX_VALUE;
        if (value1 >= value2) {
            k -= (index2 - start2 + 1);
            start2 = index2 + 1;
        } else {
            k -= (index1 - start1 + 1);
            start1 = index1 + 1;
        }
    }

    private double getResult(int[] nums1, int[] nums2) {
        int i1 = start1 <= end1 ? nums1[start1] : Integer.MAX_VALUE;
        int i3 = start1 + 1 <= end1 ? nums1[start1 + 1] : Integer.MAX_VALUE;
        int i2 = start2 <= end2 ? nums2[start2] : Integer.MAX_VALUE;
        int i4 = start2 + 1 <= end2 ? nums2[start2 + 1] : Integer.MAX_VALUE;
        if (size % 2 == 1) {
            return Math.min(i1, i2);
        } else {
            int[] ints = {i1, i2, i3, i4};
            Arrays.sort(ints);
            return (ints[0] + ints[1]) / 2.0;
        }
    }


    @Test
    public void test() {
        int[] nums1 = {};
        int[] nums2 = {6, 8};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
