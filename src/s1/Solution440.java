package s1;
// 234231234
public class Solution440 {
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    public int findKthNumber(int n, int k) {
        for (int num : nums) {
            int count = getCount(num, n);
        }
        return 0;
    }

    private int getCount(int num, int n) {
        int product = 1;
        while (product * 10 < n) {
            product *= 10;
        }
        while (num < n / product) {

        }
        return 0;
    }
}
