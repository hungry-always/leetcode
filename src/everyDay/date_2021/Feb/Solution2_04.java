package everyDay.date_2021.Feb;

/**
 * 子数组最大平均数I
 */
public class Solution2_04 {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for(int i = 0; i < k; i ++){
            sum += nums[i];
        }
        double avg = sum/k;
        for(int i = k; i < nums.length; i++){
            sum+=(nums[i]-nums[i-k]);
            avg = Math.max(avg,sum/k);
        }
        return avg;
    }
}
