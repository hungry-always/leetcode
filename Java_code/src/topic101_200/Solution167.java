package topic101_200;

public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int i = numbers[start] + numbers[end];
            if (i == target) {
                return new int[]{start + 1, end + 1};
            } else if (i > target) {
                end--;
            } else {
                start++;
            }
        }
        return null;
    }
}
