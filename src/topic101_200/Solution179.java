package topic101_200;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 最大数
 */
public class Solution179 {
    public String largestNumber(int[] nums) {
        int length = nums.length;
        if (length <= 0) {
            return "0";
        }
        String result = Arrays.stream(nums).mapToObj(String::valueOf).sorted((c1, c2) -> (c1 + c2).compareTo(c2 + c1)).collect(Collectors.joining());
        return result.startsWith("0") ? "0" : result;
    }
}
