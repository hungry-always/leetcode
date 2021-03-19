package commmon;

import cn.hutool.core.text.StrBuilder;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;

import java.util.Arrays;

public class ArraysUtils {
    public static int[] generateOne(String s) {
        JSONArray jsonArray = JSONUtil.parseArray(s);
        int[] ints = jsonArray.stream().map(o -> (Integer) o)
                .mapToInt(Integer::valueOf)
                .toArray();
        return ints;
    }

    public static int[][] generateTwo(String s) {
        return JSONUtil.parseArray(s).stream()
                .map(o -> Arrays.stream(((JSONArray) o).toArray(Integer[]::new)).mapToInt(Integer::valueOf).toArray())
                .toArray(int[][]::new);
    }

    public static void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    public static void outArray(int[] ints) {
        StrBuilder sb = new StrBuilder();
        sb.append("[");
        for (int i = 0; i < ints.length; i++) {
            sb.append(ints[i]);
            if (i != ints.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
