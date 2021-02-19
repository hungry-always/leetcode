package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution22 {
    /**
     * 括号的生成
     *
     * @param n
     * @return
     */
    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        List<String> list = map.get(n);
        if (list != null) {
            return list;
        }
        list = new ArrayList<>();
        switch (n) {
            case 0:
                list.add("");
                break;
            case 1:
                list.add("()");
                break;
            default:
                for (int i = 0; i < n; i++) {
                    List<String> list1 = generateParenthesis(i);
                    List<String> list2 = generateParenthesis(n - 1 - i);
                    for (String s : list1) {
                        for (String s1 : list2) {
                            list.add("(" + s + ")" + s1);
                        }
                    }
                }
        }
        map.put(n, list);
        return list;
    }

    @Test
    public void test() {
        System.out.println(generateParenthesis(3).toString());
    }
}
