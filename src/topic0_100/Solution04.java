package topic0_100;

import org.junit.jupiter.api.Test;

public class Solution04 {
    int start1, end1, start2, end2, k, size;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        end1 = length1 - 1;
        end2 = length2 - 1;
        size = length1 + length2;
        k = size / 2;
        while (end1 > start1 && end2 > start2) {
            moveArray(nums1, nums2);
        }
        if (end1 > start1) {
            return getResult(nums1, nums2);
        } else {
            return getResult(nums2, nums1);
        }
    }

    void moveArray(int[] nums1, int[] nums2) {
    }

    private double getResult(int[] nums1, int[] nums2) {
        return 0;
    }



    @Test
    public void test() {
        int[] nums1 = {1, 3, 5, 7, 9};
        int[] nums2 = {2, 4, 6, 8, 10};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
