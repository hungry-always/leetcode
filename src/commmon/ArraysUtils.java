package commmon;

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
    public static void main(String[] args) {
        String s = "[[1],[1]]";
        System.out.println(generateTwo(s));
    }
}
