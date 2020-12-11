package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        result.add(0);
        for (int i = 0; i < n; i++) {
            int addNumber = 1 << i;
            int size = result.size();
            for (int j = size - 1; j >= 0; j--) {
                result.add(addNumber + result.get(j));
            }
        }
        return result;
    }

    @Test
    public void test() {
        List<Integer> list = grayCode(2);
        System.out.println(list);
    }
}
