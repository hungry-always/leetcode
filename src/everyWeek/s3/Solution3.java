//package everyWeek.s3;
//
//public class Solution3 {
//    public int maxResult(int[] nums, int k) {
//        int max = nums[0];
//        int maxI = 0;
//        int temp = nums[0];
//        int tempI = 0;
//        for (int i = 1; i < nums.length; i++) {
//            int num = nums[i];
//            if (i - maxI + 1 <= k) {
//                if (num >= 0) {
//                    max += num;
//                    temp = max;
//                    maxI = tempI = i;
//                }
//            }
//        }
//    }
//}
